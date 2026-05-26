package org.xrpl.xrpl4j.model.transactions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.primitives.UnsignedLong;
import org.immutables.value.Value;
import org.immutables.value.Value.Auxiliary;
import org.immutables.value.Value.Derived;
import org.immutables.value.Value.Immutable;

/**
 * {@link CurrencyAmount} type for MPT amounts.
 */
@Immutable
@JsonSerialize(as = ImmutableMptCurrencyAmount.class)
@JsonDeserialize(as = ImmutableMptCurrencyAmount.class)
public interface MptCurrencyAmount extends CurrencyAmount {

    /**
     * Construct a {@code MptCurrencyAmount} builder.
     *
     * @return An {@link ImmutableMptCurrencyAmount.Builder}.
     */
    static ImmutableMptCurrencyAmount.Builder builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Construct a {@code MptCurrencyAmount} builder, setting {@link #value()} to the string representation of the
     * supplied {@link UnsignedLong}.
     *
     * @return An {@link ImmutableMptCurrencyAmount.Builder}.
     */
    static ImmutableMptCurrencyAmount.Builder builder(UnsignedLong value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @JsonProperty("mpt_issuance_id")
    MpTokenIssuanceId mptIssuanceId();

    String value();

    /**
     * The amount value, as an {@link UnsignedLong}.
     *
     * @return An {@link UnsignedLong}.
     */
    @Value.Auxiliary
    @JsonIgnore
    default UnsignedLong unsignedLongValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Indicates whether this amount is positive or negative.
     *
     * @return {@code true} if this amount is negative; {@code false} otherwise (i.e., if the value is 0 or positive).
     */
    @Derived
    // <-- This is not actually part of the binary serialization format, so exclude from JSON
    @JsonIgnore
    @Auxiliary
    default boolean isNegative() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Indicates whether this amount is zero.
     *
     * @return {@code true} if this amount is zero; {@code false} otherwise.
     */
    @Derived
    @JsonIgnore
    @Auxiliary
    @Override
    default boolean isZero() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
