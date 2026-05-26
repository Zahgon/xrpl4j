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
import com.google.common.base.Preconditions;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.DERSequenceGenerator;
import org.bouncycastle.asn1.DLSequence;
import org.immutables.value.Value;
import org.xrpl.xrpl4j.codec.addresses.UnsignedByteArray;
import org.xrpl.xrpl4j.crypto.keys.bc.BcKeyUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;

/**
 * A container for EcDSA signature content.
 */
@Value.Immutable
@SuppressWarnings({ "LocalVariableName", "MethodName" })
public interface EcDsaSignature {

    static ImmutableEcDsaSignature.Builder builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create an {@link EcDsaSignature} from a DER encoded byte array signature.
     *
     * @param bytes A DER encoded byte array containing a signature.
     *
     * @return An {@link EcDsaSignature}.
     */
    static EcDsaSignature fromDer(byte[] bytes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The r component of this {@link EcDsaSignature}.
     *
     * @return A {@link BigInteger} denoting the r component of this signature.
     */
    BigInteger r();

    /**
     * The s component of this {@link EcDsaSignature}.
     *
     * @return A {@link BigInteger} denoting the r component of this signature.
     */
    BigInteger s();

    /**
     * Encode this {@link EcDsaSignature} to the ASN.1 DER format.
     *
     * @return An {@link UnsignedByteArray} containing the bytes of the encoded signature.
     */
    @Value.Derived
    default UnsignedByteArray der() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Make sure signature is canonical to protect against signature morphing attacks.
     *
     * <p>Signature should be:
     * {@code <30> <len> [ <02> <lenR> <R> ] [ <02> <lenS> <S> ]} where {@code 6 <= len <= 70} {@code  1 <= lenR <= 33}
     * {@code 1 <= lenS <= 33}
     * </p>
     */
    @Value.Check
    default void isStrictlyCanonical() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
