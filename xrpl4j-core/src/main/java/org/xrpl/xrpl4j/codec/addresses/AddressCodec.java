package org.xrpl.xrpl4j.codec.addresses;

/*-
 * ========================LICENSE_START=================================
 * xrpl4j :: address-codec
 * %%
 * Copyright (C) 2020 - 2022 XRPL Foundation and its contributors
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
import static java.util.Arrays.copyOfRange;
import com.google.common.collect.Lists;
import com.google.common.primitives.UnsignedInteger;
import org.xrpl.xrpl4j.codec.addresses.exceptions.DecodeException;
import org.xrpl.xrpl4j.codec.addresses.exceptions.EncodeException;
import org.xrpl.xrpl4j.codec.addresses.exceptions.EncodingFormatException;
import org.xrpl.xrpl4j.model.transactions.Address;
import org.xrpl.xrpl4j.model.transactions.XAddress;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * A Codec for encoding/decoding various address primitives.
 */
@SuppressWarnings({ "OptionalUsedAsFieldOrParameterType", "ParameterName", "MethodName" })
public class AddressCodec {

    private static final AddressCodec INSTANCE = new AddressCodec();

    public static AddressCodec getInstance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Encode an XRPL AccountID to a Base58Check encoded {@link String}.
     *
     * @param accountId An {@link UnsignedByteArray} containing the AccountID to be encoded.
     *
     * @return The Base58 representation of accountId, as an {@link Address}.
     */
    public Address encodeAccountId(final UnsignedByteArray accountId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Decode a Base58Check encoded XRPL AccountID.
     *
     * @param accountId The Base58 encoded AccountID to be decoded, as an {@link Address}.
     *
     * @return An {@link UnsignedByteArray} containing the decoded AccountID.
     *
     * @see "https://xrpl.org/base58-encodings.html"
     */
    public UnsignedByteArray decodeAccountId(final Address accountId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Encode an XRPL Node Public Key to a Base58Check encoded {@link String}.
     *
     * @param publicKey An {@link UnsignedByteArray} containing the public key to be encoded.
     *
     * @return The Base58 representation of publicKey.
     *
     * @deprecated Prefer {@link PublicKeyCodec#encodeNodePublicKey(UnsignedByteArray)}.
     */
    @Deprecated
    public String encodeNodePublicKey(final UnsignedByteArray publicKey) {
        Objects.requireNonNull(publicKey);
        return AddressBase58.encode(publicKey, Lists.newArrayList(Version.NODE_PUBLIC), UnsignedInteger.valueOf(33));
    }

    /**
     * Decode a Base58Check encoded XRPL Node Public Key.
     *
     * @param publicKey The Base58 encoded public key to be decoded.
     *
     * @return An {@link UnsignedByteArray} containing the decoded public key.
     *
     * @see "https://xrpl.org/base58-encodings.html"
     * @deprecated Prefer {@link PublicKeyCodec#decodeNodePublicKey(String)}.
     */
    @Deprecated
    public UnsignedByteArray decodeNodePublicKey(final String publicKey) {
        Objects.requireNonNull(publicKey);
        return AddressBase58.decode(publicKey, Lists.newArrayList(Version.NODE_PUBLIC), UnsignedInteger.valueOf(33)).bytes();
    }

    /**
     * Converts an XRPL Classic Address and Destination Tag to an X-Address.
     *
     * @param classicAddress A {@link String} containing the classic address.
     * @param tag            The destination tag of the address.
     * @param test           {@code true} if the X-Address should be encoded for Testnet, {@code false} if it should be
     *                       encoded for Mainnet.
     *
     * @return The X-Address representation of the classic address and destination tag.
     */
    public XAddress classicAddressToXAddress(final Address classicAddress, final UnsignedInteger tag, final boolean test) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts an XRPL Classic Address with no Destination Tag to an X-Address.
     *
     * @param classicAddress An {@link Address} containing the classic address.
     * @param test           {@code true} if the X-Address should be encoded for Testnet, {@code false} if it should be
     *                       encoded for Mainnet.
     *
     * @return The X-Address representation of the classic address, as an {@link XAddress}.
     */
    public XAddress classicAddressToXAddress(final Address classicAddress, final boolean test) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts an XRPL Classic Address and and optional Destination Tag to an X-Address.
     *
     * @param classicAddress An {@link Address} containing the classic address.
     * @param tag            The destination tag of the address.
     * @param test           {@code true} if the X-Address should be encoded for Testnet, {@code false} if it should be
     *                       encoded for Mainnet.
     *
     * @return The X-Address representation of the classic address and destination tag, as an {@link XAddress}.
     */
    public XAddress classicAddressToXAddress(final Address classicAddress, final Optional<UnsignedInteger> tag, final boolean test) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Encodes and AccountID, destination tag, and the XRPL network into an X-Address.
     *
     * @param accountId An {@link UnsignedByteArray} containing an XRPL AccountID.
     * @param tag       (Optional) The destination tag of the account.
     * @param test      {@code true} if the X-Address should be encoded for Testnet, {@code false} if it should be encoded
     *                  for Mainnet.
     *
     * @return The X-Address representation of the AccountID and destination tag, as an {@link XAddress}.
     */
    public XAddress encodeXAddress(final UnsignedByteArray accountId, final Optional<UnsignedInteger> tag, final boolean test) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Decodes an X-Address to a Classic Address and Destination Tag.
     *
     * @param xAddress The {@link XAddress} to be decoded.
     *
     * @return The {@link ClassicAddress} decoded from xAddress.
     */
    public ClassicAddress xAddressToClassicAddress(final XAddress xAddress) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Decodes an X-Address to an AccountID, destination tag, and a boolean for XRPL-testnet or XRPL-mainnet.
     *
     * @param xAddress The {@link XAddress} to be decoded.
     *
     * @return The {@link DecodedXAddress} decoded from xAddress.
     */
    public DecodedXAddress decodeXAddress(final XAddress xAddress) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private UnsignedInteger tagFromDecodedXAddress(final byte[] decoded) {
        Objects.requireNonNull(decoded);
        byte flag = decoded[22];
        if (flag >= 2) {
            throw new DecodeException("Unsupported X-Address: 64-bit tags are not supported");
        }
        if (flag == 1) {
            // Little-endian to big-endian
            return UnsignedInteger.valueOf(decoded[23] & 0xff).plus(UnsignedInteger.valueOf((decoded[24] & 0xff) * 0x100)).plus(UnsignedInteger.valueOf((decoded[25] & 0xff) * 0x10000)).plus(UnsignedInteger.valueOf(0x1000000).times(UnsignedInteger.valueOf(decoded[26] & 0xff)));
        } else if (flag == 0) {
            byte[] endBytes = new byte[8];
            Arrays.fill(endBytes, (byte) 0);
            if (!Arrays.equals(copyOfRange(decoded, 23, 31), endBytes)) {
                throw new DecodeException("Tag bytes in XAddress must be 0 if the address has no tag.");
            } else {
                return UnsignedInteger.ZERO;
            }
        } else {
            throw new DecodeException("Flag must be 0 to indicate no tag.");
        }
    }

    private boolean isTestAddress(final byte[] decoded) {
        Objects.requireNonNull(decoded);
        byte[] prefix = copyOfRange(decoded, 0, 2);
        if (Arrays.equals(PrefixBytes.MAIN, prefix)) {
            return false;
        } else if (Arrays.equals(PrefixBytes.TEST, prefix)) {
            return true;
        } else {
            throw new DecodeException("Invalid X-Address: Bad Prefix");
        }
    }

    /**
     * Tests if the given X-Address is a valid X-Address.
     *
     * @param xAddress A potentially valid {@link XAddress}.
     *
     * @return {@code true} if the given address is a valid X-Address, {@code false} if not.
     */
    public boolean isValidXAddress(final XAddress xAddress) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tests if the given Address is a valid Classic Address.
     *
     * @param address A potentially valid classic {@link Address}.
     *
     * @return {@code true} if the given address is a valid Classic Address, {@code false} if not.
     */
    public boolean isValidClassicAddress(final Address address) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static final class PrefixBytes {

        static byte[] MAIN = new byte[] { 0x05, 0x44 };

        static byte[] TEST = new byte[] { 0x04, (byte) 0x93 };
    }
}
