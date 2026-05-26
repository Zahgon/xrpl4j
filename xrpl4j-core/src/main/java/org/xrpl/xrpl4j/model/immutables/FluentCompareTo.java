package org.xrpl.xrpl4j.model.immutables;

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
/**
 * Provides a fluent, readable alternative to {@link Comparable#compareTo(Object)}. Instead of code like {@code
 * someValue.compareTo(someOtherValue) <= 0} you can write {@code is(someValue).lessThanOrEqualTo(someOtherValue) }.
 * Also provides stronger type safety so you can't accidentally compare apples to oranges.
 */
public class FluentCompareTo<T extends Comparable<? super T>> {

    private final T value;

    private FluentCompareTo(T value) {
        this.value = value;
    }

    /**
     * Create a {@link FluentCompareTo} for the given value.
     *
     * @param value value to wrap
     * @param <T>   the Java type of the wrapped value
     *
     * @return wrapped value
     */
    public static <T extends Comparable<? super T>> FluentCompareTo<T> is(T value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create a {@link FluentCompareTo} for the given value.
     *
     * @param value value to wrap
     * @param <T>   the Java type of the wrapped value
     *
     * @return wrapped value
     */
    public static <T extends Comparable<? super T>> FluentCompareTo<T> isNot(T value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if wrapped value is equal than the given one.
     *
     * @param other given value
     *
     * @return true if wrapped value is equal to given value
     */
    public boolean equalTo(T other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if wrapped value is not equal than the given one.
     *
     * @param other given value
     *
     * @return true if wrapped value is not equal to given value
     */
    public boolean notEqualTo(T other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if wrapped value is less than than the given one.
     *
     * @param other given value
     *
     * @return true if wrapped value is less than given value
     */
    public boolean lessThan(T other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if wrapped value is not less than than the given one.
     *
     * @param other given value
     *
     * @return true if wrapped value is not less than given value
     */
    public boolean notLessThan(T other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if wrapped value is less than or equal to than the given one.
     *
     * @param other given value
     *
     * @return true if wrapped value is less than or equal given value
     */
    public boolean lessThanOrEqualTo(T other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if wrapped value is not less than or equal to than the given one.
     *
     * @param other given value
     *
     * @return true if wrapped value is not less than or equal given value
     */
    public boolean notLessThanOrEqualTo(T other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if wrapped value is greater than than the given one.
     *
     * @param other given value
     *
     * @return true if wrapped value is greater than given value
     */
    public boolean greaterThan(T other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if wrapped value is not greater than than the given one.
     *
     * @param other given value
     *
     * @return true if wrapped value is not greater than given value
     */
    public boolean notGreaterThan(T other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if wrapped value is greater than or equal to than the given one.
     *
     * @param other given value
     *
     * @return true if wrapped value is greater than given value
     */
    public boolean greaterThanEqualTo(T other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if wrapped value is not greater than or equal to than the given one.
     *
     * @param other given value
     *
     * @return true if wrapped value is not greater than given value
     */
    public boolean notGreaterThanEqualTo(T other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if wrapped value is between two given values (inclusive lower bound, exclusive upper bound).
     *
     * @param startInclusive lower bound inclusive value
     * @param endExclusive   upper bound exclusive value
     *
     * @return true if not between
     */
    public boolean between(T startInclusive, T endExclusive) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if wrapped value is not between two given values (inclusive lower bound, exclusive upper bound).
     *
     * @param startInclusive lower bound inclusive value
     * @param endExclusive   upper bound exclusive value
     *
     * @return true if not between
     */
    public boolean notBetween(T startInclusive, T endExclusive) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if wrapped value is between 2 given values (exclusive lower bound, exclusive upper bound).
     *
     * @param startExclusive lower bound exclusive value
     * @param endExclusive   upper bound exclusive value
     *
     * @return true if between
     */
    public boolean betweenExclusive(T startExclusive, T endExclusive) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if wrapped value is not between two given values (exclusive lower bound, exclusive upper bound).
     *
     * @param startExclusive lower bound exclusive value
     * @param endExclusive   upper bound exclusive value
     *
     * @return true if not between
     */
    public boolean notBetweenExclusive(T startExclusive, T endExclusive) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get the underlying value of this {@link FluentCompareTo}.
     *
     * @return This {@link FluentCompareTo}'s underlying value, as type {@link T}.
     */
    public T getValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
