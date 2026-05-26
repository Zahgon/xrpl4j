package org.xrpl.xrpl4j.model.flags;

/*-
 * ========================LICENSE_START=================================
 * xrpl4j :: model
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
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * A wrapper around a long value containing various XRPL Transaction Flags.
 *
 * @see "https://xrpl.org/transaction-common-fields.html#flags-field"
 */
public class Flags {

    /**
     * Constant for an unset flag.
     */
    public static final Flags UNSET = new Flags(0);

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    private final Optional<Long> value;

    Flags(long value) {
        this.value = Optional.of(value);
    }

    Flags() {
        this.value = Optional.empty();
    }

    /**
     * Construct {@link Flags} for the given value.
     *
     * @param value A long flags value.
     *
     * @return A new {@link Flags}.
     */
    public static Flags of(long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Construct {@link Flags} from one or more {@link Flags} by performing a bitwise OR on all.
     *
     * @param flag   The first {@link Flags}.
     * @param others Zero or more other {@link Flags} to include.
     *
     * @return A new {@link Flags}.
     */
    public static Flags of(Flags flag, Flags... others) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get the underlying value of this {@link Flags}.
     *
     * @return The underlying {@code long} value of this {@link Flags}.
     */
    public long getValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns whether these {@link TransactionFlags} are empty.
     *
     * @return {@code true} if these flags are empty, otherwise {@code false}.
     */
    public boolean isEmpty() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Performs a bitwise OR on this {@link Flags} and another {@link Flags}.
     *
     * @param other The {@link Flags} to perform the OR with.
     *
     * @return The {@link Flags} resulting from the OR operation.
     */
    Flags bitwiseOr(Flags other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Performs a bitwise AND on this {@link Flags} and another {@link Flags}.
     *
     * @param other The {@link Flags} to perform the AND with.
     *
     * @return The {@link Flags} resulting from the AND operation.
     */
    Flags bitwiseAnd(Flags other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Determines if a specific transaction flag is set by performing a bitwise AND on this {@link Flags} and the {@link
     * Flags} in question, and checking if the result of that operation is equal to the given flag.
     *
     * @param flag The {@link Flags} that this method determines is set or not.
     *
     * @return true if the flag is set, false if not.
     */
    public boolean isSet(Flags flag) {
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
}
