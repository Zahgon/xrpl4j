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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.Lists;
import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;
import com.google.common.primitives.UnsignedInteger;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.immutables.value.Value.Derived;
import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Lazy;
import org.xrpl.xrpl4j.codec.addresses.AddressBase58;
import org.xrpl.xrpl4j.codec.addresses.AddressCodec;
import org.xrpl.xrpl4j.codec.addresses.Decoded;
import org.xrpl.xrpl4j.codec.addresses.KeyType;
import org.xrpl.xrpl4j.codec.addresses.PublicKeyCodec;
import org.xrpl.xrpl4j.codec.addresses.UnsignedByte;
import org.xrpl.xrpl4j.codec.addresses.UnsignedByteArray;
import org.xrpl.xrpl4j.codec.addresses.Version;
import org.xrpl.xrpl4j.model.jackson.modules.PublicKeyDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.PublicKeySerializer;
import org.xrpl.xrpl4j.model.transactions.Address;
import org.xrpl.xrpl4j.model.transactions.Transaction;
import java.util.Objects;

/**
 * A typed instance of an XRPL Seed, which can be decoded into an instance of {@link Decoded}.
 */
@Immutable
@JsonSerialize(as = ImmutablePublicKey.class, using = PublicKeySerializer.class)
@JsonDeserialize(as = ImmutablePublicKey.class, using = PublicKeyDeserializer.class)
public interface PublicKey {

    /**
     * A one-byte prefix for ed25519 keys. In XRPL, ed25519 public keys are prefixed with a one-byte prefix (i.e., `0xED`)
     * in order to be consistent with secp256k1 public keys, which always have 33 bytes.
     */
    UnsignedByte ED2559_PREFIX = UnsignedByte.of(0xED);

    /**
     * Multi-signed transactions must contain an empty String in the SigningPublicKey field. This constant is an
     * {@link PublicKey} that can be used as the {@link Transaction#signingPublicKey()} value for multi-signed
     * transactions.
     */
    PublicKey MULTI_SIGN_PUBLIC_KEY = PublicKey.builder().value(UnsignedByteArray.empty()).build();

    /**
     * Instantiates a new builder.
     *
     * @return A {@link ImmutablePublicKey.Builder}.
     */
    static ImmutablePublicKey.Builder builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Construct a {@link PublicKey} from a base58-encoded {@link String}.
     *
     * @param base58EncodedPublicKey A base58-encoded {@link String}.
     *
     * @return A {@link PrivateKey}.
     */
    static PublicKey fromBase58EncodedPublicKey(final String base58EncodedPublicKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Construct a {@link PrivateKey} from a base16-encoded (HEX) {@link String}.
     *
     * @param base16EncodedPublicKey A base16-encoded (HEX) {@link String}.
     *
     * @return A {@link PrivateKey}.
     */
    static PublicKey fromBase16EncodedPublicKey(final String base16EncodedPublicKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The key in binary (Note: will be 33 bytes).
     *
     * @return An instance of {@link UnsignedByteArray}.
     */
    UnsignedByteArray value();

    /**
     * The public-key, as a base-58 encoded {@link String}.
     *
     * @return A {@link String}.
     */
    @Derived
    default String base58Value() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The private-key value, as a Base16-encoded (i.e., HEX) string. Note that if this is an Ed25519 private-key, then
     * this value contains a leading prefix of `ED`, in hex.
     *
     * @return A {@link String}.
     */
    @Derived
    default String base16Value() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The type of this key.
     *
     * @return A {@link KeyType}.
     */
    @Derived
    default KeyType keyType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Derive an XRPL address from this public key.
     *
     * @return A Base58Check encoded XRPL address in Classic Address form.
     */
    @Lazy
    default Address deriveAddress() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Compute the RIPEMD160 of the SHA256 of the given public key, which can be encoded to an XRPL address.
     *
     * @param publicKey The public key that should be hashed.
     *
     * @return An {@link UnsignedByteArray} containing the non-encoded XRPL address derived from the public key.
     */
    static UnsignedByteArray computePublicKeyHash(final UnsignedByteArray publicKey) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
