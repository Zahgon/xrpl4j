package org.xrpl.xrpl4j.model.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedInteger;
import org.immutables.value.Value;
import org.xrpl.xrpl4j.model.flags.LoanSetFlags;
import java.math.BigDecimal;
import java.util.Optional;

/**
 * Create a new Loan.
 *
 * <p>This class will be marked {@link Beta} until the LendingProtocol amendment is enabled on mainnet. Its API is
 * subject to change.</p>
 */
@Value.Immutable
@JsonSerialize(as = ImmutableLoanSet.class)
@JsonDeserialize(as = ImmutableLoanSet.class)
@Beta
public interface LoanSet extends Transaction {

    /**
     * Construct a {@code LoanSet} builder.
     *
     * @return An {@link ImmutableLoanSet.Builder}.
     */
    static ImmutableLoanSet.Builder builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Set of {@link LoanSetFlags}s for this {@link LoanSet}.
     *
     * @return A {@link LoanSetFlags}.
     */
    @JsonProperty("Flags")
    @Value.Default
    default LoanSetFlags flags() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The Loan Broker ID associated with the loan.
     *
     * @return A {@link Hash256}.
     */
    @JsonProperty("LoanBrokerID")
    Hash256 loanBrokerId();

    /**
     * The address of the counterparty of the Loan. This field may be absent when LoanBroker is the counterparty.
     *
     * @return An optionally-present {@link Address}.
     */
    @JsonProperty("Counterparty")
    Optional<Address> counterparty();

    /**
     * The signature of the counterparty over the transaction.
     *
     * <p>This field is {@link Optional} because both parties must sign the same serialized transaction bytes,
     * and {@code CounterpartySignature} is excluded from those bytes by design. The dual-signing flow is:
     * <ol>
     *   <li>The broker constructs a {@link LoanSet} with this field absent and signs it — the absent field
     *       produces the canonical bytes that both parties will sign.</li>
     *   <li>The counterparty signs the same bytes (over the same absent-field transaction) and returns their
     *       signature.</li>
     *   <li>The broker/counterparty assembles the final transaction by adding the counterparty signature here and
     *      submits it.</li>
     * </ol>
     *
     * <p>If this field were required, it would be impossible to construct the intermediate unsigned object
     * needed to obtain the signable bytes in step 1, breaking the entire dual-signing protocol.
     *
     * <p>When present, the value must be a valid signature from a key authorized for the counterparty account
     * (master key, regular key, or a quorum of multi-signers).
     *
     * @return An optionally-present {@link CounterpartySignature}.
     */
    @JsonProperty("CounterpartySignature")
    Optional<CounterpartySignature> counterpartySignature();

    /**
     * Arbitrary metadata in hex format. The field is limited to 256 bytes.
     *
     * @return An optionally-present {@link LoanData}.
     */
    @JsonProperty("Data")
    Optional<LoanData> data();

    /**
     * A nominal funds amount paid to the {@code LoanBroker.Owner} when the Loan is created.
     *
     * @return An optionally-present {@link Amount}.
     */
    @JsonProperty("LoanOriginationFee")
    Optional<Amount> loanOriginationFee();

    /**
     * A nominal amount paid to the {@code LoanBroker.Owner} with every Loan payment.
     *
     * @return An optionally-present {@link Amount}.
     */
    @JsonProperty("LoanServiceFee")
    Optional<Amount> loanServiceFee();

    /**
     * A nominal funds amount paid to the {@code LoanBroker.Owner} when a payment is late.
     *
     * @return An optionally-present {@link Amount}.
     */
    @JsonProperty("LatePaymentFee")
    Optional<Amount> latePaymentFee();

    /**
     * A nominal funds amount paid to the {@code LoanBroker.Owner} when an early full repayment is made.
     *
     * @return An optionally-present {@link Amount}.
     */
    @JsonProperty("ClosePaymentFee")
    Optional<Amount> closePaymentFee();

    /**
     * A fee charged on overpayments in 1/10th basis points. Valid values are between 0 and 100000 inclusive
     * (0 - 100%).
     *
     * @return An optionally-present {@link UnsignedInteger}.
     */
    @JsonProperty("OverpaymentFee")
    Optional<UnsignedInteger> overpaymentFee();

    /**
     * Annualized interest rate of the Loan in 1/10th basis points. Valid values are between 0 and 100000
     * inclusive (0 - 100%).
     *
     * @return An optionally-present {@link UnsignedInteger}.
     */
    @JsonProperty("InterestRate")
    Optional<UnsignedInteger> interestRate();

    /**
     * A premium added to the interest rate for late payments in 1/10th basis points. Valid values are between
     * 0 and 100000 inclusive (0 - 100%).
     *
     * @return An optionally-present {@link UnsignedInteger}.
     */
    @JsonProperty("LateInterestRate")
    Optional<UnsignedInteger> lateInterestRate();

    /**
     * A Fee Rate charged for repaying the Loan early in 1/10th basis points. Valid values are between 0 and
     * 100000 inclusive (0 - 100%).
     *
     * @return An optionally-present {@link UnsignedInteger}.
     */
    @JsonProperty("CloseInterestRate")
    Optional<UnsignedInteger> closeInterestRate();

    /**
     * An interest rate charged on overpayments in 1/10th basis points. Valid values are between 0 and 100000
     * inclusive (0 - 100%).
     *
     * @return An optionally-present {@link UnsignedInteger}.
     */
    @JsonProperty("OverpaymentInterestRate")
    Optional<UnsignedInteger> overpaymentInterestRate();

    /**
     * The principal amount requested by the Borrower.
     *
     * @return An {@link Amount}.
     */
    @JsonProperty("PrincipalRequested")
    Amount principalRequested();

    /**
     * The total number of payments to be made against the Loan.
     *
     * @return An optionally-present {@link UnsignedInteger}.
     */
    @JsonProperty("PaymentTotal")
    Optional<UnsignedInteger> paymentTotal();

    /**
     * Number of seconds between Loan payments.
     *
     * @return An optionally-present {@link UnsignedInteger}.
     */
    @JsonProperty("PaymentInterval")
    Optional<UnsignedInteger> paymentInterval();

    /**
     * The number of seconds after the Loan's Payment Due Date can be Defaulted.
     *
     * @return An optionally-present {@link UnsignedInteger}.
     */
    @JsonProperty("GracePeriod")
    Optional<UnsignedInteger> gracePeriod();

    /**
     * Validates LoanSet data verification preconditions.
     */
    @Value.Check
    default void check() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
