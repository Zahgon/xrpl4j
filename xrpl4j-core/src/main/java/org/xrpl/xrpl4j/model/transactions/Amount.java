package org.xrpl.xrpl4j.model.transactions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.primitives.UnsignedLong;
import org.immutables.value.Value.Auxiliary;
import org.immutables.value.Value.Check;
import org.immutables.value.Value.Immutable;
import org.xrpl.xrpl4j.model.jackson.modules.AmountDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.AmountSerializer;
import org.xrpl.xrpl4j.model.ledger.Issue;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A transaction-level object meant to model the XRPL's `NUMBER` type, but at the RPC layer. The `NUMBER` type in XRPL
 * is made up of 12 bytes (8 bytes representing a mantissa, and 4 bytes representing an exponent). However, in RPC, this
 * value is represented as a string for two reasons. First, Issued Currency Amounts can be negative and can also be
 * represented in scientific notation, which must be a String. Second, this allows for easier JSON representation.
 *
 * <p>Therefore, this interface is called `Amount` (to subtly differentiate from an actual `NUMBER` type) and it is
 * likewise not called `NumberAmount` so that it can eventually be slotted well (from a naming perspective) into the
 * {@link CurrencyAmount} interface.
 *
 * <p><strong>Design Note:</strong> Unlike the {@link CurrencyAmount} interface, which is not meant to be
 * instantiated (only its subtypes should be instaniated), this interface _is_ meant to be instantiated. This is
 * primarily because of the Lending Protocol (XLS-66) which stores unitless numbers in places like the `LoanBroker` and
 * `Loan` objects. In Java, these values are loaded via RPC without any kind of unit/currency indicator. To get these,
 * the Java developer will need to make an addition RPC to get the underlying Single Asset Vault connected to any loan,
 * and then discover the {@link Issue} from the vault. From there, this class can be transformed into a
 * {@link CurrencyAmount} using {@link #toCurrencyAmount(Issue)}.
 * </p>
 */
@Immutable
@JsonSerialize(as = ImmutableAmount.class, using = AmountSerializer.class)
@JsonDeserialize(as = ImmutableAmount.class, using = AmountDeserializer.class)
public interface Amount {

    /**
     * An {@link Amount} representing zero.
     */
    Amount ZERO = Amount.of("0");

    /**
     * Creates an {@link Amount} instance from the given string value.
     *
     * @param value A non-null {@link String} representing the value of the amount.
     *
     * @return A non-null {@link Amount} instance with the specified value.
     *
     * @throws NullPointerException if {@code value} is null.
     */
    static Amount of(final String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The wire-format string representation of this amount. For XRP and MPT, this is a decimal integer string (optionally
     * prefixed with {@code -}). For Issued Currency Amounts (IOUs), this may additionally contain a decimal point or
     * scientific-notation exponent.
     *
     * @return A non-null {@link String}.
     */
    String value();

    /**
     * Whether this amount is negative.
     *
     * @return {@code true} if the drop count is negative; {@code false} otherwise.
     */
    @Auxiliary
    @JsonIgnore
    default boolean isNegative() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Whether this amount is zero.
     *
     * @return {@code true} if the value is numerically zero; {@code false} otherwise.
     */
    @Auxiliary
    @JsonIgnore
    default boolean isZero() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the value as a {@link BigDecimal} for arithmetic or comparison purposes.
     *
     * @return A {@link BigDecimal} representing this IOU amount.
     */
    @Auxiliary
    @JsonIgnore
    default BigDecimal bigDecimalValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts this amount to a {@link CurrencyAmount} based on the provided {@link Issue}.
     *
     * @param issue The {@link Issue} representing the type of currency (e.g., XRP, IOU, or MPT) for which a corresponding
     *              {@link CurrencyAmount} will be created. Must not be null.
     *
     * @return A {@link CurrencyAmount} instance that represents the current amount in the specific currency of the
     *   provided {@link Issue}.
     *
     * @throws NullPointerException if {@code issue} is null.
     */
    @Auxiliary
    @JsonIgnore
    default CurrencyAmount toCurrencyAmount(final Issue issue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Normalizes the {@code value} field so that any numeric representation of zero (e.g. {@code "-0"}, {@code "0.00"},
     * {@code "0e5"}) is canonicalized to the string {@code "0"}.
     *
     * <p>This method is invoked by the Immutables framework after every construction path — both via the
     * builder and via {@code copyOf}/{@code with*} — so the normalization cannot be bypassed even when callers use
     * {@code ImmutableAmount.builder()} directly.</p>
     *
     * @return {@code this} if the value is already canonical, or a new {@link Amount} whose {@code value()} is
     *   {@code "0"} if the value is numerically zero.
     */
    @Check
    default Amount normalizeValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
