package org.xrpl.xrpl4j.model.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import org.immutables.value.Value;
import org.xrpl.xrpl4j.model.flags.LoanManageFlags;

/**
 * Default, impair, or unimpair a Loan.
 *
 * <p>This class will be marked {@link Beta} until the LendingProtocol amendment is enabled on mainnet. Its API is
 * subject to change.</p>
 */
@Value.Immutable
@JsonSerialize(as = ImmutableLoanManage.class)
@JsonDeserialize(as = ImmutableLoanManage.class)
@Beta
public interface LoanManage extends Transaction {

    /**
     * Construct a {@code LoanManage} builder.
     *
     * @return An {@link ImmutableLoanManage.Builder}.
     */
    static ImmutableLoanManage.Builder builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Set of {@link LoanManageFlags}s for this {@link LoanManage}.
     *
     * @return A {@link LoanManageFlags}.
     */
    @JsonProperty("Flags")
    @Value.Default
    default LoanManageFlags flags() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The ID of the Loan object to be updated.
     *
     * @return A {@link Hash256}.
     */
    @JsonProperty("LoanID")
    Hash256 loanId();

    /**
     * Validates LoanManage data verification preconditions per the Lending Protocol spec section 3.10.4.1.
     */
    @Value.Check
    default void check() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
