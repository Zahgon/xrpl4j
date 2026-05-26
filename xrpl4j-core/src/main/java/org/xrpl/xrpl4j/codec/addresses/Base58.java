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
import org.xrpl.xrpl4j.codec.addresses.exceptions.EncodingFormatException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Utility class for encoding and decoding in Base58.  Includes methods for encoding and decoding with a 4 byte
 * checksum, which is necessary for XRPL Address encoding.
 */
public class Base58 {

    public static final char[] ALPHABET = "rpshnaf39wBUDNEGHJKLM4PQRST7VWXYZ2bcdeCg65jkm8oFqi1tuvAxyz".toCharArray();

    private static final int[] INDEXES = new int[255];

    static {
        Arrays.fill(INDEXES, -1);
        for (int i = 0; i < ALPHABET.length; i++) {
            INDEXES[ALPHABET[i]] = i;
        }
    }

    /**
     * Encodes the given bytes to a Base58 {@link String}.
     *
     * @param input A byte array to encode.
     *
     * @return The bytes encoded to a Base58 {@link String}
     */
    public static String encode(byte[] input) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Decodes a Base58 encoded {@link String} to a byte array.
     *
     * @param input The Base58 {@link String}.
     *
     * @return A byte array containing the decoded Base58 {@link String}.
     */
    public static byte[] decode(String input) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Encodes the given byte array to a Base58 {@link String} with a 4 byte checksum appended.
     *
     * @param bytes The byte array to encode.
     *
     * @return A {@link String} containing the Base58Check encoded bytes.
     */
    public static String encodeChecked(byte[] bytes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Decodes the given Base58Check encoded {@link String} to a byte array, and validates the checksum.
     *
     * @param input A Base58Check encoded {@link String}.
     *
     * @return A byte array containing the decoded value.
     * @throws EncodingFormatException If the input is not Base58 encoded or the checksum does not validate.
     */
    public static byte[] decodeChecked(String input) throws EncodingFormatException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static byte divmod58(byte[] number, int startAt) {
        int remainder = 0;
        for (int i = startAt; i < number.length; i++) {
            int digit256 = (int) number[i] & 0xFF;
            int temp = remainder * 256 + digit256;
            number[i] = (byte) (temp / 58);
            remainder = temp % 58;
        }
        return (byte) remainder;
    }

    private static byte divmod256(byte[] number58, int startAt) {
        int remainder = 0;
        for (int i = startAt; i < number58.length; i++) {
            int digit58 = (int) number58[i] & 0xFF;
            int temp = remainder * 58 + digit58;
            number58[i] = (byte) (temp / 256);
            remainder = temp % 256;
        }
        return (byte) remainder;
    }
}
