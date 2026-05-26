package org.xrpl.xrpl4j.crypto;

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
import static java.util.Arrays.copyOfRange;
import com.google.common.hash.Hashing;
import org.xrpl.xrpl4j.codec.addresses.UnsignedByte;
import org.xrpl.xrpl4j.codec.addresses.UnsignedByteArray;
import java.util.Objects;

/**
 * Hashing utilities for XRPL-related hashing algorithms.
 */
public class HashingUtils {

    /**
     * Compute a SHA-512 hash of the given bytes and return the first half of the result.
     *
     * @param bytes The bytes to half hash.
     *
     * @return An {@link UnsignedByteArray} containing the first half of the SHA-512 hash of bytes.
     */
    public static UnsignedByteArray sha512Half(final UnsignedByteArray bytes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Compute a SHA-512 hash of the given bytes and return the first half of the result.
     *
     * @param bytes The bytes to half hash.
     *
     * @return An {@link UnsignedByteArray} containing the first half of the SHA-512 hash of bytes.
     */
    public static UnsignedByteArray sha512Half(final byte[] bytes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Add an Unsigned 32-bit integer to an {@link UnsignedByteArray}.
     *
     * @param bytes        An {@link UnsignedByteArray} to append to.
     * @param integerToAdd An {@link Integer} with 4 signed bytes to add to bytes.
     *
     * @return The resulting {@link UnsignedByteArray}.
     */
    public static UnsignedByteArray addUInt32(final UnsignedByteArray bytes, final Integer integerToAdd) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
