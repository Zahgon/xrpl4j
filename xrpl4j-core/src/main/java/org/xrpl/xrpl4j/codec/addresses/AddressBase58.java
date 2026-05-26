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
import com.google.common.collect.Lists;
import com.google.common.primitives.UnsignedInteger;
import org.xrpl.xrpl4j.codec.addresses.exceptions.DecodeException;
import org.xrpl.xrpl4j.codec.addresses.exceptions.EncodeException;
import org.xrpl.xrpl4j.codec.addresses.exceptions.EncodingFormatException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Extension of {@link Base58} to provide XRPL Address specific Base58 encoding and decoding functionality.
 */
public class AddressBase58 extends Base58 {

    /**
     * Encodes the given {@link UnsignedByteArray} to a Base58Check {@link String}.
     *
     * @param bytes          An {@link UnsignedByteArray} of data to encode.
     * @param versions       A {@link List} of {@link Version}s which should be prepended to bytes.
     * @param expectedLength The expected length of the result.
     *
     * @return The Base58Check encoded {@link String} of the given parameters.
     */
    public static String encode(final UnsignedByteArray bytes, final List<Version> versions, final UnsignedInteger expectedLength) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Concatenates the given {@link Version} bytes with the given input bytes, and Base58Check encodes the result.
     *
     * @param bytes    The bytes to encode.
     * @param versions The {@link Version} to encode with.
     *
     * @return A {@link String} containing the Base58Check encoded bytes.
     */
    public static String encodeChecked(final byte[] bytes, final List<Version> versions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Decode a Base58Check {@link String} with no specified {@link KeyType}s or expected length.
     *
     * @param base58Value The Base58Check encoded {@link String} to be decoded.
     * @param version     The {@link Version} to try decoding with.
     *
     * @return A {@link Decoded} containing the decoded value and version.
     *
     * @throws EncodingFormatException If the version bytes of the Base58 value are invalid.
     */
    public static Decoded decode(final String base58Value, final Version version) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Decode a Base58Check {@link String} with no specified {@link KeyType}s.
     *
     * @param base58Value    The Base58Check encoded {@link String} to be decoded.
     * @param versions       A {@link List} of {@link Version}s to try decoding with.
     * @param expectedLength The expected length of the decoded value.
     *
     * @return A {@link Decoded} containing the decoded value and version.
     */
    public static Decoded decode(final String base58Value, final List<Version> versions, final UnsignedInteger expectedLength) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Decode a Base58Check {@link String}.
     *
     * @param base58Value    The Base58Check encoded {@link String} to be decoded.
     * @param keyTypes       A {@link List} of {@link KeyType}s which can be associated with the result of this method.
     * @param versions       A {@link List} of {@link Version}s to try decoding with.
     * @param expectedLength The expected length of the decoded value.
     *
     * @return A {@link Decoded} containing the decoded value, version, and type.
     *
     * @throws EncodingFormatException If more than one version is supplied without an expectedLength value present, or if
     *                                 the version bytes of the Base58 value are invalid.
     */
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public static Decoded decode(final String base58Value, final List<KeyType> keyTypes, final List<Version> versions, final Optional<UnsignedInteger> expectedLength) throws EncodingFormatException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
