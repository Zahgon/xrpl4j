package org.xrpl.xrpl4j.model.transactions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.annotations.Beta;

/**
 * The withdrawal strategy for a Vault. The only defined value is {@code 1} (first-come-first-serve).
 */
@Beta
public enum WithdrawalPolicy {

    /**
     * First-come-first-serve withdrawal strategy.
     */
    FIRST_COME_FIRST_SERVE(1);

    private final int value;

    WithdrawalPolicy(int value) {
        this.value = value;
    }

    /**
     * Get the integer value of this {@link WithdrawalPolicy}.
     *
     * @return The integer value.
     */
    @JsonValue
    public int getValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Construct a {@link WithdrawalPolicy} from an integer value.
     *
     * @param value The integer value.
     *
     * @return The {@link WithdrawalPolicy} for the given value.
     */
    @JsonCreator
    public static WithdrawalPolicy forValue(int value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
