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
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import java.math.BigInteger;
import java.util.Objects;
import javax.security.auth.Destroyable;

/**
 * Unsigned byte where value can be 0 to 255.
 */
public class UnsignedByte implements Destroyable {

    // since Java byte is signed need to use int to handle max value 255
    private int value;

    private boolean destroyed;

    private UnsignedByte(final int value) {
        Preconditions.checkArgument(value >= 0);
        Preconditions.checkArgument(value <= 255);
        this.value = value;
    }

    /**
     * Copy constructor. Constructs an {@link UnsignedByte} from an {@code UnsignedByte}.
     *
     * @param value An {@code int} value.
     *
     * @return An {@link UnsignedByte}.
     */
    public static UnsignedByte of(final UnsignedByte value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Construct an {@link UnsignedByte} from an {@code int}.
     *
     * @param value An {@code int} value.
     *
     * @return An {@link UnsignedByte}.
     */
    public static UnsignedByte of(final int value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Construct an {@link UnsignedByte} from a {@code byte}.
     *
     * @param value A {@code byte} value.
     *
     * @return An {@link UnsignedByte}.
     */
    public static UnsignedByte of(final byte value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Construct an {@link UnsignedByte} from high bits and low bits.
     *
     * @param highBits A {@code byte} of the high bits.
     * @param lowBits  A {@code byte} of the low bits.
     *
     * @return An {@link UnsignedByte}.
     */
    public static UnsignedByte of(final byte highBits, final byte lowBits) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Construct an {@link UnsignedByte} from a hexadecimal {@link String}.
     *
     * @param hex A hexadecimal encoded {@link String}.
     *
     * @return An {@link UnsignedByte}.
     */
    public static UnsignedByte of(final String hex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts the {@link UnsignedByte} to a signed int. Necessary if the {@link UnsignedByte} has a value greater than
     * 127 and the result needs to be used for numeric purposes.
     *
     * @return This {@link UnsignedByte}'s value as a signed int.
     */
    public int asInt() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts the {@link UnsignedByte} to a signed byte. Note that this can be unsafe to do if the underlying value is
     * greater than 127 which is the max value for signed byte in Java AND the byte is being used for numerical purposes.
     *
     * @return This {@link UnsignedByte}'s value as a signed byte.
     */
    public byte asByte() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets the 4 high order bits of the underlying {@link UnsignedByte}.
     *
     * @return The 4 high order bits of this {@link UnsignedByte}.
     */
    public int getHighBits() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets the 4 low order bits of the underlying {@link UnsignedByte}.
     *
     * @return The 4 low order bits of this {@link UnsignedByte}.
     */
    public int getLowBits() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if the nth bit (1-based index from left to right) is set.
     *
     * @param nth The index of the bit to check.
     *
     * @return {@code true} if the nth bit is set, otherwise {@code false}.
     */
    public boolean isNthBitSet(final int nth) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Does a bitwise OR on this {@link UnsignedByte} and the given {@link UnsignedByte}, and returns a new
     * {@link UnsignedByte} as the result.
     *
     * @param unsignedByte The {@link UnsignedByte} to perform a bitwise OR on.
     *
     * @return The result of the bitwise OR operation.
     */
    public UnsignedByte or(final UnsignedByte unsignedByte) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Encodes this {@link UnsignedByte} as a hexadecimal {@link String}.
     *
     * @return The hex {@link String} value of this {@link UnsignedByte}.
     */
    public String hexValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(final Object object) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
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
