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
import com.google.common.annotations.Beta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import javax.security.auth.Destroyable;

/**
 * <p>Wrapper for holding unsigned bytes since unsigned bytes are hard in Java and XRPL ledger does many operations on
 * arrays on unsigned bytes.</p>
 *
 * <p>Note: several of the methods in this class mutate the underlying value.</p>
 */
public class UnsignedByteArray implements Destroyable {

    private final List<UnsignedByte> unsignedBytes;

    private boolean destroyed;

    public UnsignedByteArray(final List<UnsignedByte> unsignedBytes) {
        Objects.requireNonNull(unsignedBytes);
        this.unsignedBytes = unsignedBytes;
    }

    /**
     * Creates an {@link UnsignedByteArray} from a byte array.
     *
     * @param bytes The byte array to create an {@link UnsignedByteArray} from.
     *
     * @return An {@link UnsignedByteArray} containing {@code bytes}.
     */
    public static UnsignedByteArray of(final byte[] bytes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates an {@link UnsignedByteArray} from one or more {@link UnsignedByte} values.
     *
     * @param first An {@link UnsignedByte} to include in the resulting {@link UnsignedByteArray}.
     * @param rest  Other {@link UnsignedByte}s to include in the resulting {@link UnsignedByteArray}.
     *
     * @return An {@link UnsignedByteArray} with the given {@link UnsignedByte}s.
     */
    public static UnsignedByteArray of(UnsignedByte first, UnsignedByte... rest) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates an empty {@link UnsignedByteArray}.
     *
     * @return An empty {@link UnsignedByteArray}.
     */
    public static UnsignedByteArray empty() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates an {@link UnsignedByteArray} with a given number of bytes (where each byte has the value 0).
     *
     * @param size The size of the initialized {@link UnsignedByteArray}.
     *
     * @return An {@link UnsignedByteArray} of the requested size with all 0 {@link UnsignedByte}s
     */
    public static UnsignedByteArray ofSize(int size) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts a hex string to an {@link UnsignedByteArray}.
     *
     * @param hex A hexadecimal encoded {@link String}.
     *
     * @return The hex value as an {@link UnsignedByteArray}.
     */
    public static UnsignedByteArray fromHex(String hex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected static List<UnsignedByte> fill(int amount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get the underlying {@link List} of {@link UnsignedByte}s for this {@link UnsignedByteArray}.
     *
     * @return The underlying {@link List} of {@link UnsignedByte}s.
     */
    public List<UnsignedByte> getUnsignedBytes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts this {@link UnsignedByteArray} to a byte array.
     *
     * @return This {@link UnsignedByteArray} as a byte array.
     */
    public byte[] toByteArray() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get this {@link UnsignedByteArray} as an upper-cased Hex-encoded {@link String}.
     *
     * @return This {@link UnsignedByteArray} as a hex encoded {@link String}.
     */
    public String hexValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get the length of this {@link UnsignedByteArray}.
     *
     * @return The length of this {@link UnsignedByteArray}, as an int.
     */
    public int length() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets the {@link UnsignedByte} at a given index.
     *
     * @param index The index of the {@link UnsignedByte} to get.
     *
     * @return The {@link UnsignedByte} at the given index.
     */
    public UnsignedByte get(int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Appends an {@link UnsignedByte} to this {@link UnsignedByteArray}.
     *
     * @param unsignedByte An {@link UnsignedByte} to append.
     *
     * @return This {@link UnsignedByteArray}, with the given {@link UnsignedByte} appended.
     */
    public UnsignedByteArray append(UnsignedByte unsignedByte) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Appends the given bytes to the end of this array. Note: this method mutates the instance and returns the same
     * instance (mainly for call chaining convenience).
     *
     * @param array An {@link UnsignedByteArray} to append to this {@link UnsignedByteArray}.
     *
     * @return the same instance.
     */
    public UnsignedByteArray append(UnsignedByteArray array) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the value at the given index to the given {@link UnsignedByte}.
     *
     * @param index The index to set.
     * @param value The {@link UnsignedByte} to set at the given index.
     */
    public void set(int index, UnsignedByte value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a slice of the underlying byte array from the given start to the end index (exclusive).
     *
     * @param startIndex start index (inclusive)
     * @param endIndex   end index (exclusive)
     *
     * @return An {@link UnsignedByteArray} containing the sliced elements.
     */
    public UnsignedByteArray slice(int startIndex, int endIndex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new {@link UnsignedByteArray} with the bytes in reversed order.
     * This is useful for converting between big-endian and little-endian byte order.
     *
     * @return A new {@link UnsignedByteArray} with bytes in reversed order.
     */
    @Beta
    public UnsignedByteArray reverse() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object object) {
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

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isDestroyed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
