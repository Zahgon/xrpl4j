package org.xrpl.xrpl4j.crypto.keys;

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
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.hash.Hashing;
import com.google.common.primitives.UnsignedInteger;
import org.bouncycastle.asn1.sec.SECNamedCurves;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.xrpl.xrpl4j.codec.addresses.AddressBase58;
import org.xrpl.xrpl4j.codec.addresses.Base58;
import org.xrpl.xrpl4j.codec.addresses.Decoded;
import org.xrpl.xrpl4j.codec.addresses.KeyType;
import org.xrpl.xrpl4j.codec.addresses.SeedCodec;
import org.xrpl.xrpl4j.codec.addresses.UnsignedByteArray;
import org.xrpl.xrpl4j.codec.addresses.Version;
import org.xrpl.xrpl4j.codec.addresses.exceptions.DecodeException;
import org.xrpl.xrpl4j.crypto.HashingUtils;
import org.xrpl.xrpl4j.crypto.signing.bc.Secp256k1;
import java.math.BigInteger;
import java.util.Objects;
import java.util.Optional;

/**
 * A compact value that is used to derive the actual private and public keys for an XRPL account.
 *
 * @see "https://xrpl.org/cryptographic-keys.html#seed"
 */
public interface Seed extends javax.security.auth.Destroyable {

    /**
     * The decoded details of this seed.
     *
     * @return An instance of {@link Decoded}.
     */
    Decoded decodedSeed();

    /**
     * Derive a public/private keypair from a Base58Check encoded 16 byte seed.
     *
     * @return The {@link KeyPair} derived from the seed.
     */
    KeyPair deriveKeyPair();

    /**
     * Construct an Ed25519-compatible {@link Seed} from the supplied {@link Passphrase}.
     *
     * @param passphrase A {@link Passphrase} to generate a seed from.
     *
     * @return A {@link Seed}.
     */
    static Seed ed25519SeedFromPassphrase(final Passphrase passphrase) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Construct an secp256k1-compatible {@link Seed} from the supplied {@link Passphrase}.
     *
     * @param passphrase A {@link Passphrase} to generate a seed from.
     *
     * @return A {@link Seed}.
     */
    static Seed secp256k1SeedFromPassphrase(final Passphrase passphrase) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Construct an Ed25519-compatible {@link Seed} using a random {@link Entropy} instance. This random {@link Entropy}
     * is created using {@link Entropy#newInstance()}.
     *
     * @return A {@link Seed}.
     */
    static Seed ed25519Seed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Construct an Ed25519-compatible {@link Seed} from the supplied {@link Entropy}.
     *
     * @param entropy A {@link Entropy} to generate a {@link Seed} from.
     *
     * @return A {@link Seed}.
     */
    static Seed ed25519SeedFromEntropy(final Entropy entropy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Construct a secp256k1-compatible {@link Seed} using a random {@link Entropy} instance. This random {@link Entropy}
     * is created using {@link Entropy#newInstance()}.
     *
     * @return A {@link Seed}.
     */
    static Seed secp256k1Seed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Construct a secp256k1-compatible {@link Seed} from the supplied {@link Entropy}.
     *
     * @param entropy A {@link Entropy} to generate a {@link Seed} from.
     *
     * @return A {@link Seed}.
     */
    static Seed secp256k1SeedFromEntropy(final Entropy entropy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Construct a {@link Seed} from the supplied {@code base58EncodedSecret}. Values for this function are most commonly
     * found from an XRP Faucet, for example for the XRP devnet or testnet. On the xrpl.org documentation page, this value
     * is often referred to as an account "secret", but it is actually just a base58-encoded string that contains an
     * encoded 16-bytes of entropy, in addition to other binary padding and identification data.
     *
     * @param base58EncodedSecret A base58-encoded {@link String} that represents an encoded seed.
     *
     * @return A {@link Seed}.
     *
     * @see "https://xrpl.org/xrp-testnet-faucet.html"
     */
    static Seed fromBase58EncodedSecret(final Base58EncodedSecret base58EncodedSecret) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * A default implementation of a {@link Seed}.
     */
    class DefaultSeed implements Seed {

        // This holds all Seed bytes (e.g., entropy bytes, version type, etc).
        private final UnsignedByteArray value;

        private boolean destroyed;

        /**
         * Required-args Constructor. Purposefully package-private for testing purposes only (use a static method instead
         * for construction).
         *
         * @param value This seed's full binary value (including the entropy bytes and keyType).
         */
        @VisibleForTesting
        DefaultSeed(final UnsignedByteArray value) {
            this.value = Objects.requireNonNull(value);
        }

        /**
         * Copy constructor.
         *
         * @param seed This seed's full binary value (including the entropy bytes and keyType).
         */
        @VisibleForTesting
        DefaultSeed(final DefaultSeed seed) {
            Objects.requireNonNull(seed);
            this.value = UnsignedByteArray.of(seed.value.toByteArray());
            this.destroyed = seed.isDestroyed();
        }

        /**
         * The decoded details of this seed.
         *
         * @return An instance of {@link Decoded}.
         */
        public Decoded decodedSeed() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public KeyPair deriveKeyPair() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public final void destroy() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public final boolean isDestroyed() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean equals(Object obj) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int hashCode() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Encapsulates algorithms to derive ED25519 keys.
         */
        @VisibleForTesting
        static class Ed25519KeyPairService {

            /**
             * Private, no-args constructor to prevent instantiation.
             */
            private Ed25519KeyPairService() {
            }

            /**
             * Derive a {@link KeyPair} from the supplied {@code seed}.
             *
             * @param seed A {@link Seed}.
             *
             * @return A newly generated {@link KeyPair}.
             */
            public static KeyPair deriveKeyPair(final Seed seed) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }

        /**
         * Encapsulates algorithms to derive ECDSA keys using the secp256k1 curve.
         */
        @VisibleForTesting
        static class Secp256k1KeyPairService {

            /**
             * Static constants for Secp256k1.
             */
            static X9ECParameters EC_PARAMETERS = SECNamedCurves.getByName("secp256k1");

            static ECDomainParameters EC_DOMAIN_PARAMETERS = new ECDomainParameters(EC_PARAMETERS.getCurve(), EC_PARAMETERS.getG(), EC_PARAMETERS.getN(), EC_PARAMETERS.getH());

            /**
             * Private, no-args constructor to prevent instantiation.
             */
            private Secp256k1KeyPairService() {
            }

            /**
             * Derive a {@link KeyPair} from the supplied {@code seed}.
             *
             * @param seed A {@link Seed}.
             *
             * @return A newly generated {@link KeyPair}.
             */
            public static KeyPair deriveKeyPair(final Seed seed) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            /**
             * Derive a {@link KeyPair} from the supplied {@code seed} as an {@link UnsignedByteArray}.
             * <p>
             * Note that multiple keypairs can be derived from the same {@code seedBytes} using the secp256k1 algorithm by
             * deriving keys from a {@code seedBytes} and an account index of type {@code UInt32}. However, this use-case is
             * incredibly uncommon, and a vast majority of users use 0 for the account index. Thus, while this function allows
             * for an account index to be supplied, this implementation does not allow for custom account indexes for deriving
             * secp256k1 keys and always uses  value of `0`.
             * </p>
             *
             * @param seedBytes An {@link UnsignedByteArray} of length 16 containing a seedBytes.
             *
             * @return A {@link KeyPair} containing a public/private keypair derived from seedBytes using the secp2561k
             *   algorithm.
             */
            private static KeyPair deriveKeyPair(final UnsignedByteArray seedBytes, final int accountNumber) {
                Objects.requireNonNull(seedBytes);
                // private key needs to be a BigInteger, so we can derive the public key by multiplying G by the private key.
                final BigInteger privateKeyInt = derivePrivateKey(seedBytes, accountNumber);
                // This derivePublicKey will pad to 33 bytes.
                final UnsignedByteArray publicKeyByteArray = derivePublicKey(privateKeyInt);
                // This merely enforces the invariant that should be defined in `derivePublicKey(privateKeyInt);`
                Preconditions.checkArgument(publicKeyByteArray.length() == 33, "Length was " + publicKeyByteArray.length());
                return KeyPair.builder().privateKey(PrivateKey.fromPrefixedBytes(Secp256k1.toUnsignedByteArray(privateKeyInt, 33))).publicKey(PublicKey.builder().value(publicKeyByteArray).build()).build();
            }

            /**
             * Derive a public key from the supplied {@code privateKey}.
             *
             * @param privateKey A {@link BigInteger} representing the private key component of a secp256k1 keypair.
             *
             * @return An {@link UnsignedInteger} representing the public key component of a secp256k1 keypair.
             */
            private static UnsignedByteArray derivePublicKey(final BigInteger privateKey) {
                Objects.requireNonNull(privateKey);
                UnsignedByteArray unpaddedBytes = UnsignedByteArray.of(EC_DOMAIN_PARAMETERS.getG().multiply(privateKey).getEncoded(true));
                // <-- Ensure returned UBA has 33 bytes.
                return Secp256k1.withZeroPrefixPadding(unpaddedBytes, 33);
            }

            /**
             * Derive a public key from the supplied {@code seed} and {@code accountNumber}.
             *
             * @param seed          A {@link UnsignedByteArray} representing a seed that can be used to generate an XRPL
             *                      address.
             * @param accountNumber An integer representing the account nunmber.
             *
             * @return An {@link UnsignedInteger} representing the public key component of a secp256k1 keypair.
             */
            private static BigInteger derivePrivateKey(final UnsignedByteArray seed, final int accountNumber) {
                Objects.requireNonNull(seed);
                BigInteger privateGen = deriveScalar(seed);
                if (accountNumber == -1) {
                    return privateGen;
                }
                UnsignedByteArray publicGen = UnsignedByteArray.of(EC_DOMAIN_PARAMETERS.getG().multiply(privateGen).getEncoded(true));
                return deriveScalar(publicGen, accountNumber).add(privateGen).mod(EC_DOMAIN_PARAMETERS.getN());
            }

            /**
             * Helper to derive a scalar component for secp256k1.
             *
             * @param seed A {@link UnsignedByteArray} representing a seed.
             *
             * @return An {@link BigInteger} representing a corresponding scalar value.
             */
            private static BigInteger deriveScalar(final UnsignedByteArray seed) {
                Objects.requireNonNull(seed);
                return deriveScalar(seed, Optional.empty());
            }

            /**
             * Helper to derive a scalar component for secp256k1.
             *
             * @param seed          A {@link UnsignedByteArray} representing a seed.
             * @param discriminator An integer used as a discriminator for deriving a scalar.
             *
             * @return An {@link BigInteger} representing a corresponding scalar value.
             */
            private static BigInteger deriveScalar(final UnsignedByteArray seed, final Integer discriminator) {
                Objects.requireNonNull(seed);
                Objects.requireNonNull(discriminator);
                return deriveScalar(seed, Optional.of(discriminator));
            }

            /**
             * Helper to derive a scalar component for secp256k1.
             *
             * @param seed          A {@link UnsignedByteArray} representing a seed.
             * @param discriminator An optionally present {@link Integer} used as a discriminator for deriving a scalar.
             *
             * @return An {@link BigInteger} representing a corresponding scalar value.
             */
            @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
            private static BigInteger deriveScalar(final UnsignedByteArray seed, final Optional<Integer> discriminator) {
                Objects.requireNonNull(seed);
                Objects.requireNonNull(discriminator);
                BigInteger key = null;
                UnsignedByteArray seedCopy = UnsignedByteArray.of(seed.toByteArray());
                for (long i = 0; i <= 0xFFFFFFFFL; i++) {
                    discriminator.map(d -> HashingUtils.addUInt32(seedCopy, d));
                    HashingUtils.addUInt32(seedCopy, (int) i);
                    UnsignedByteArray hash = HashingUtils.sha512Half(seedCopy);
                    key = new BigInteger(1, hash.toByteArray());
                    if (key.compareTo(BigInteger.ZERO) > 0 && key.compareTo(EC_DOMAIN_PARAMETERS.getN()) < 0) {
                        break;
                    }
                }
                return key;
            }
        }
    }
}
