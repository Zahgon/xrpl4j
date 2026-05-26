package org.xrpl.xrpl4j.crypto.keys.bc;

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
import static org.xrpl.xrpl4j.codec.addresses.KeyType.ED25519;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.math.ec.ECPoint;
import org.xrpl.xrpl4j.codec.addresses.KeyType;
import org.xrpl.xrpl4j.codec.addresses.UnsignedByteArray;
import org.xrpl.xrpl4j.crypto.keys.PrivateKey;
import org.xrpl.xrpl4j.crypto.keys.PublicKey;
import org.xrpl.xrpl4j.crypto.signing.bc.Secp256k1;
import java.math.BigInteger;
import java.security.Security;
import java.util.Arrays;
import java.util.Objects;

/**
 * Utility class for converting between XRPL-4j public/private keys and BouncyCastle implementations.
 */
public final class BcKeyUtils {

    private static final String SECP256K1 = "secp256k1";

    private static final ECNamedCurveParameterSpec EC_PARAMS = ECNamedCurveTable.getParameterSpec(SECP256K1);

    public static final ECDomainParameters PARAMS = new ECDomainParameters(EC_PARAMS.getCurve(), EC_PARAMS.getG(), EC_PARAMS.getN(), EC_PARAMS.getH());

    static {
        if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null) {
            final BouncyCastleProvider bcProvider = new BouncyCastleProvider();
            if (Security.addProvider(bcProvider) == -1) {
                throw new RuntimeException("Could not configure BouncyCastle provider");
            }
        }
    }

    /**
     * No-args Constructor to prevent instantiation.
     */
    private BcKeyUtils() {
    }

    /**
     * Convert from a {@link Ed25519PrivateKeyParameters} to a {@link PrivateKey}.
     *
     * @param ed25519PrivateKeyParameters A {@link Ed25519PrivateKeyParameters}.
     *
     * @return A {@link PrivateKey}.
     */
    public static PrivateKey toPrivateKey(final Ed25519PrivateKeyParameters ed25519PrivateKeyParameters) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert from a {@link ECPrivateKeyParameters} to a {@link PrivateKey}.
     *
     * @param ecPrivateKeyParameters A {@link ECPrivateKeyParameters}.
     *
     * @return A {@link PrivateKey}.
     */
    public static PrivateKey toPrivateKey(final ECPrivateKeyParameters ecPrivateKeyParameters) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert from a {@link PublicKey} to a {@link Ed25519PublicKeyParameters}.
     *
     * @param publicKey A {@link PublicKey} with
     *
     * @return A {@link Ed25519PublicKeyParameters}.
     */
    public static Ed25519PublicKeyParameters toEd25519PublicKeyParameters(final PublicKey publicKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert from a {@link Ed25519PublicKeyParameters} to a {@link PublicKey}.
     *
     * @param ed25519PublicKeyParameters A {@link Ed25519PublicKeyParameters}.
     *
     * @return A {@link PublicKey}.
     */
    public static PublicKey toPublicKey(final Ed25519PublicKeyParameters ed25519PublicKeyParameters) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert from a {@link ECPublicKeyParameters} to a {@link PublicKey}.
     *
     * @param ecPublicKeyParameters A {@link ECPublicKeyParameters}.
     *
     * @return A {@link PublicKey}.
     */
    public static PublicKey toPublicKey(final ECPublicKeyParameters ecPublicKeyParameters) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert from a {@link ECPrivateKeyParameters} to a {@link PublicKey}.
     *
     * @param ecPrivateKeyParameters A {@link ECPrivateKeyParameters}.
     *
     * @return A {@link PublicKey}.
     */
    public static ECPublicKeyParameters toPublicKey(final ECPrivateKeyParameters ecPrivateKeyParameters) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert from a {@link PrivateKey} to a {@link PublicKey}.
     *
     * @param privateKey A {@link PrivateKey}.
     *
     * @return A {@link PublicKey}.
     */
    public static PublicKey toPublicKey(final PrivateKey privateKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert from a {@link PrivateKey} to a {@link Ed25519PrivateKeyParameters}.
     *
     * @param privateKey A {@link PrivateKey}.
     *
     * @return A {@link Ed25519PrivateKeyParameters}.
     */
    public static Ed25519PrivateKeyParameters toEd25519PrivateKeyParams(PrivateKey privateKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert from a {@link PublicKey} to a {@link ECPublicKeyParameters}.
     *
     * @param publicKey A {@link PublicKey} with
     *
     * @return A {@link ECPublicKeyParameters}.
     */
    public static ECPublicKeyParameters toEcPublicKeyParameters(final PublicKey publicKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert from a {@link PrivateKey} to a {@link ECPrivateKeyParameters}.
     *
     * @param privateKey A {@link PrivateKey}.
     *
     * @return A {@link ECPrivateKeyParameters}.
     */
    public static ECPrivateKeyParameters toEcPrivateKeyParams(final PrivateKey privateKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
