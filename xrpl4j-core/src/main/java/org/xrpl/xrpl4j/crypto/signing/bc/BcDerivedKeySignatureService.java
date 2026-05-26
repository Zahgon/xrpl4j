package org.xrpl.xrpl4j.crypto.signing.bc;

/*-
 * ========================LICENSE_START=================================
 * xrpl4j :: core
 * %%
 * Copyright (C) 2020 - 2023 XRPL Foundation and its contributors
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.CaffeineSpec;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import com.google.common.hash.Hashing;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.signers.ECDSASigner;
import org.bouncycastle.crypto.signers.Ed25519Signer;
import org.bouncycastle.crypto.signers.HMacDSAKCalculator;
import org.xrpl.xrpl4j.codec.addresses.KeyType;
import org.xrpl.xrpl4j.crypto.ServerSecret;
import org.xrpl.xrpl4j.crypto.ServerSecretSupplier;
import org.xrpl.xrpl4j.crypto.keys.KeyPair;
import org.xrpl.xrpl4j.crypto.keys.Passphrase;
import org.xrpl.xrpl4j.crypto.keys.PrivateKey;
import org.xrpl.xrpl4j.crypto.keys.PrivateKeyReference;
import org.xrpl.xrpl4j.crypto.keys.PublicKey;
import org.xrpl.xrpl4j.crypto.keys.Seed;
import org.xrpl.xrpl4j.crypto.keys.bc.BcKeyUtils;
import org.xrpl.xrpl4j.crypto.signing.Signature;
import org.xrpl.xrpl4j.crypto.signing.SignatureService;
import org.xrpl.xrpl4j.crypto.signing.SignatureUtils;
import org.xrpl.xrpl4j.crypto.signing.SingleSignedTransaction;
import org.xrpl.xrpl4j.model.client.channels.UnsignedClaim;
import org.xrpl.xrpl4j.model.ledger.Attestation;
import org.xrpl.xrpl4j.model.transactions.Batch;
import org.xrpl.xrpl4j.model.transactions.LoanSet;
import org.xrpl.xrpl4j.model.transactions.Signer;
import org.xrpl.xrpl4j.model.transactions.Transaction;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

/**
 * An implementation of {@link SignatureService} that uses an in-memory secret value to deterministically create a seed
 * value that can then be used to generate XRPL private keys. This implementation keeps a cache of instances of
 * {@link SignatureService} that it delegates to based upon the {@link PrivateKeyReference} supplied on each call.
 *
 * <p>WARNING: This implementation stores private seed-generation material in-memory. Depending on your security
 * requirements, consider a different implementation of {@link SignatureService}.</p>
 */
public class BcDerivedKeySignatureService implements SignatureService<PrivateKeyReference> {

    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    private final LoadingCache<PrivateKeyReference, BcSingleKeyTransactionSigner> transactionSignerCache;

    private final ServerSecretSupplier serverSecretSupplier;

    // Supplied to the loading cache on each create.
    private final BcSignatureService commonBcSignatureService;

    /**
     * Required-args Constructor.
     *
     * @param serverSecretSupplier A {@link ServerSecretSupplier} that can be used to generate seed values, which can
     */
    public BcDerivedKeySignatureService(final ServerSecretSupplier serverSecretSupplier) {
        this(serverSecretSupplier, CaffeineSpec.parse("maximumSize=10000,expireAfterWrite=30s"));
    }

    /**
     * Required-args Constructor.
     *
     * @param serverSecretSupplier A {@link ServerSecretSupplier} that can be used to generate seed values, which can
     * @param caffeineSpec         A {@link CaffeineSpec} that can be initialized externally to configure the Caffeine
     *                             cache constructed by this service.
     */
    public BcDerivedKeySignatureService(final ServerSecretSupplier serverSecretSupplier, final CaffeineSpec caffeineSpec) {
        this.serverSecretSupplier = Objects.requireNonNull(serverSecretSupplier);
        this.transactionSignerCache = Caffeine.from(Objects.requireNonNull(caffeineSpec)).build(this::constructTransactionSigner);
        this.commonBcSignatureService = new BcSignatureService(SignatureUtils.getInstance(), new Ed25519Signer(), new ECDSASigner(new HMacDSAKCalculator(new SHA256Digest())));
    }

    @Override
    public PublicKey derivePublicKey(final PrivateKeyReference privateKeyable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T extends Transaction> SingleSignedTransaction<T> sign(final PrivateKeyReference privateKeyReference, final T transaction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Signature sign(final PrivateKeyReference privateKeyReference, final UnsignedClaim unsignedClaim) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Signature sign(final PrivateKeyReference privateKeyReference, final Attestation attestation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T extends Transaction> Signature multiSign(final PrivateKeyReference privateKeyReference, final T transaction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Signature signInner(final PrivateKeyReference privateKeyable, final Batch batchTransaction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Signature multiSignInner(final PrivateKeyReference privateKeyable, final Batch batchTransaction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Signature counterpartySign(final PrivateKeyReference privateKeyReference, final LoanSet transaction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Signature counterpartyMultiSign(final PrivateKeyReference privateKeyReference, final LoanSet transaction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T extends Transaction> Signer multiSignToSigner(PrivateKeyReference privateKeyable, T transaction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T extends Transaction> boolean verify(final Signer signer, final T unsignedTransaction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T extends Transaction> boolean verifyMultiSigned(final Set<Signer> signerSet, final T unsignedTransaction, final int minSigners) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    //////////////////
    // Private Helpers
    //////////////////
    /**
     * Construct a new {@link BcSingleKeyTransactionSigner} using the provided {@code privateKeyReference}.
     *
     * @param privateKeyReference A {@link PrivateKeyReference} with information about a private key.
     *
     * @return A {@link BcSingleKeyTransactionSigner}.
     */
    @VisibleForTesting
    final BcSingleKeyTransactionSigner constructTransactionSigner(final PrivateKeyReference privateKeyReference) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Deterministically generate a {@link Seed} based upon the supplied XRPL account identifier and a server-secret that
     * is loaded into memory.
     *
     * @param accountIdentifier A {@link String} that is combined with an in-memory server secret to deterministically
     *                          generate a seed for entropy.
     *
     * @return A {@link Seed} that can be used to generate an XRPL public/private key pair.
     *
     * @see "https://xrpl.org/cryptographic-keys.html#key-derivation"
     */
    @VisibleForTesting
    final Seed generateEd25519XrplSeed(final String accountIdentifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Deterministically generate a {@link Seed} based upon the supplied XRPL account identifier and a server-secret that
     * is loaded into memory.
     *
     * @param accountIdentifier A {@link String} that is combined with an in-memory server secret to deterministically
     *                          generate a seed for entropy.
     *
     * @return A {@link Seed} that can be used to generate an XRPL public/private key pair.
     *
     * @see "https://xrpl.org/cryptographic-keys.html#key-derivation"
     */
    @VisibleForTesting
    final Seed generateSecp256k1Seed(final String accountIdentifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Helper method to return an instance of {@link BcSingleKeyTransactionSigner} or else throw an exception.
     *
     * @param privateKeyReference The {@link PrivateKeyReference} of the key to return.
     *
     * @return A {@link BcSingleKeyTransactionSigner}.
     */
    private BcSingleKeyTransactionSigner getTransactionSigner(final PrivateKeyReference privateKeyReference) {
        Objects.requireNonNull(privateKeyReference);
        // Try to load from the loading cache...
        return this.transactionSignerCache.get(privateKeyReference);
    }

    /**
     * <p>A transaction signer that uses BouncyCastle internally with a single private key.</p>
     *
     * <p>WARNING: This implementation utilizes in-memory private-key material. Consider using an alternative
     * implementation that relies upon {@link PrivateKeyReference} instead for improved security.</p>
     */
    private static class BcSingleKeyTransactionSigner {

        private final PrivateKey privateKey;

        private final BcSignatureService bcSignatureService;

        public BcSingleKeyTransactionSigner(final PrivateKey privateKey, final BcSignatureService bcSignatureService) {
            this.privateKey = Objects.requireNonNull(privateKey);
            this.bcSignatureService = Objects.requireNonNull(bcSignatureService);
        }

        public final <T extends Transaction> SingleSignedTransaction<T> sign(final T transaction) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Signature sign(final UnsignedClaim unsignedClaim) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Signature sign(final Attestation attestation) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public <T extends Transaction> Signature multiSign(final T transaction) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        // @deprecated See comment in `TransactionSigner#multiSignToSigner`.
        @Deprecated
        public <T extends Transaction> Signer multiSignToSigner(T transaction) {
            return bcSignatureService.multiSignToSigner(this.privateKey, transaction);
        }

        public final Signature signInner(final Batch transaction) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public final Signature multiSignInner(final Batch transaction) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public final Signature counterpartySign(final LoanSet transaction) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public final Signature counterpartyMultiSign(final LoanSet transaction) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public PublicKey getPublicKey() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
