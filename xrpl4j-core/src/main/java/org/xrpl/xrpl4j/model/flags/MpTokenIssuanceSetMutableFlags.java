package org.xrpl.xrpl4j.model.flags;

/**
 * A set of static {@link Flags} which can be set in the {@code MutableFlags} field of
 * {@link org.xrpl.xrpl4j.model.transactions.MpTokenIssuanceSet} transactions.
 *
 * <p>These flags (prefixed with {@code tmf}) set or clear specific flags on an existing
 * {@code MPTokenIssuance} that were declared mutable at creation time.
 *
 * @see <a href="https://github.com/XRPLF/XRPL-Standards/tree/master/XLS-0094-dynamic-MPT">XLS-94</a>
 */
@SuppressWarnings("abbreviationaswordinname")
public class MpTokenIssuanceSetMutableFlags extends Flags {

    /**
     * Sets the {@code lsfMPTCanLock} flag. Enables the token to be locked both individually and globally.
     * Hex: {@code 0x00000001}.
     */
    public static final MpTokenIssuanceSetMutableFlags SET_CAN_LOCK = new MpTokenIssuanceSetMutableFlags(0x00000001);

    /**
     * Clears the {@code lsfMPTCanLock} flag. Disables both individual and global locking of the token.
     * Hex: {@code 0x00000002}.
     */
    public static final MpTokenIssuanceSetMutableFlags CLEAR_CAN_LOCK = new MpTokenIssuanceSetMutableFlags(0x00000002);

    /**
     * Sets the {@code lsfMPTRequireAuth} flag. Requires individual holders to be authorized.
     * Hex: {@code 0x00000004}.
     */
    public static final MpTokenIssuanceSetMutableFlags SET_REQUIRE_AUTH = new MpTokenIssuanceSetMutableFlags(0x00000004);

    /**
     * Clears the {@code lsfMPTRequireAuth} flag. Holders are not required to be authorized.
     * Hex: {@code 0x00000008}.
     */
    public static final MpTokenIssuanceSetMutableFlags CLEAR_REQUIRE_AUTH = new MpTokenIssuanceSetMutableFlags(0x00000008);

    /**
     * Sets the {@code lsfMPTCanEscrow} flag. Allows holders to place balances into escrow.
     * Hex: {@code 0x00000010}.
     */
    public static final MpTokenIssuanceSetMutableFlags SET_CAN_ESCROW = new MpTokenIssuanceSetMutableFlags(0x00000010);

    /**
     * Clears the {@code lsfMPTCanEscrow} flag. Disallows holders from placing balances into escrow.
     * Hex: {@code 0x00000020}.
     */
    public static final MpTokenIssuanceSetMutableFlags CLEAR_CAN_ESCROW = new MpTokenIssuanceSetMutableFlags(0x00000020);

    /**
     * Sets the {@code lsfMPTCanTrade} flag. Allows holders to trade balances on the XRPL DEX.
     * Hex: {@code 0x00000040}.
     */
    public static final MpTokenIssuanceSetMutableFlags SET_CAN_TRADE = new MpTokenIssuanceSetMutableFlags(0x00000040);

    /**
     * Clears the {@code lsfMPTCanTrade} flag. Disallows holders from trading balances on the XRPL DEX.
     * Hex: {@code 0x00000080}.
     */
    public static final MpTokenIssuanceSetMutableFlags CLEAR_CAN_TRADE = new MpTokenIssuanceSetMutableFlags(0x00000080);

    /**
     * Sets the {@code lsfMPTCanTransfer} flag. Allows tokens to be transferred to non-issuer accounts.
     * Hex: {@code 0x00000100}.
     */
    public static final MpTokenIssuanceSetMutableFlags SET_CAN_TRANSFER = new MpTokenIssuanceSetMutableFlags(0x00000100);

    /**
     * Clears the {@code lsfMPTCanTransfer} flag. Disallows transfers to non-issuer accounts.
     * Hex: {@code 0x00000200}.
     */
    public static final MpTokenIssuanceSetMutableFlags CLEAR_CAN_TRANSFER = new MpTokenIssuanceSetMutableFlags(0x00000200);

    /**
     * Sets the {@code lsfMPTCanClawback} flag. Enables the issuer to claw back tokens.
     * Hex: {@code 0x00000400}.
     */
    public static final MpTokenIssuanceSetMutableFlags SET_CAN_CLAWBACK = new MpTokenIssuanceSetMutableFlags(0x00000400);

    /**
     * Clears the {@code lsfMPTCanClawback} flag. The token cannot be clawed back.
     * Hex: {@code 0x00000800}.
     */
    public static final MpTokenIssuanceSetMutableFlags CLEAR_CAN_CLAWBACK = new MpTokenIssuanceSetMutableFlags(0x00000800);

    /**
     * All valid bits for the {@code MutableFlags} field on {@code MPTokenIssuanceSet}
     * (bits {@code 0x001}–{@code 0x800}).
     */
    public static final long VALID_MASK = SET_CAN_LOCK.getValue() | CLEAR_CAN_LOCK.getValue() | SET_REQUIRE_AUTH.getValue() | CLEAR_REQUIRE_AUTH.getValue() | SET_CAN_ESCROW.getValue() | CLEAR_CAN_ESCROW.getValue() | SET_CAN_TRADE.getValue() | CLEAR_CAN_TRADE.getValue() | SET_CAN_TRANSFER.getValue() | CLEAR_CAN_TRANSFER.getValue() | SET_CAN_CLAWBACK.getValue() | CLEAR_CAN_CLAWBACK.getValue();

    private MpTokenIssuanceSetMutableFlags(long value) {
        super(value);
    }

    private MpTokenIssuanceSetMutableFlags() {
    }

    /**
     * Construct {@link MpTokenIssuanceSetMutableFlags} for the given raw value.
     *
     * @param value The long-number encoded flags value.
     *
     * @return A new {@link MpTokenIssuanceSetMutableFlags}.
     */
    public static MpTokenIssuanceSetMutableFlags of(long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static MpTokenIssuanceSetMutableFlags of(boolean tmfMPTSetCanLock, boolean tmfMPTClearCanLock, boolean tmfMPTSetRequireAuth, boolean tmfMPTClearRequireAuth, boolean tmfMPTSetCanEscrow, boolean tmfMPTClearCanEscrow, boolean tmfMPTSetCanTrade, boolean tmfMPTClearCanTrade, boolean tmfMPTSetCanTransfer, boolean tmfMPTClearCanTransfer, boolean tmfMPTSetCanClawback, boolean tmfMPTClearCanClawback) {
        return new MpTokenIssuanceSetMutableFlags(Flags.of(tmfMPTSetCanLock ? SET_CAN_LOCK : UNSET, tmfMPTClearCanLock ? CLEAR_CAN_LOCK : UNSET, tmfMPTSetRequireAuth ? SET_REQUIRE_AUTH : UNSET, tmfMPTClearRequireAuth ? CLEAR_REQUIRE_AUTH : UNSET, tmfMPTSetCanEscrow ? SET_CAN_ESCROW : UNSET, tmfMPTClearCanEscrow ? CLEAR_CAN_ESCROW : UNSET, tmfMPTSetCanTrade ? SET_CAN_TRADE : UNSET, tmfMPTClearCanTrade ? CLEAR_CAN_TRADE : UNSET, tmfMPTSetCanTransfer ? SET_CAN_TRANSFER : UNSET, tmfMPTClearCanTransfer ? CLEAR_CAN_TRANSFER : UNSET, tmfMPTSetCanClawback ? SET_CAN_CLAWBACK : UNSET, tmfMPTClearCanClawback ? CLEAR_CAN_CLAWBACK : UNSET).getValue());
    }

    /**
     * Create a new {@link Builder}.
     *
     * @return A new {@link Builder}.
     */
    public static Builder builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Whether the {@code tmfMPTSetCanLock} flag is set.
     *
     * @return {@code true} if set, otherwise {@code false}.
     */
    public boolean tmfMptSetCanLock() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Whether the {@code tmfMPTClearCanLock} flag is set.
     *
     * @return {@code true} if set, otherwise {@code false}.
     */
    public boolean tmfMptClearCanLock() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Whether the {@code tmfMPTSetRequireAuth} flag is set.
     *
     * @return {@code true} if set, otherwise {@code false}.
     */
    public boolean tmfMptSetRequireAuth() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Whether the {@code tmfMPTClearRequireAuth} flag is set.
     *
     * @return {@code true} if set, otherwise {@code false}.
     */
    public boolean tmfMptClearRequireAuth() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Whether the {@code tmfMPTSetCanEscrow} flag is set.
     *
     * @return {@code true} if set, otherwise {@code false}.
     */
    public boolean tmfMptSetCanEscrow() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Whether the {@code tmfMPTClearCanEscrow} flag is set.
     *
     * @return {@code true} if set, otherwise {@code false}.
     */
    public boolean tmfMptClearCanEscrow() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Whether the {@code tmfMPTSetCanTrade} flag is set.
     *
     * @return {@code true} if set, otherwise {@code false}.
     */
    public boolean tmfMptSetCanTrade() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Whether the {@code tmfMPTClearCanTrade} flag is set.
     *
     * @return {@code true} if set, otherwise {@code false}.
     */
    public boolean tmfMptClearCanTrade() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Whether the {@code tmfMPTSetCanTransfer} flag is set.
     *
     * @return {@code true} if set, otherwise {@code false}.
     */
    public boolean tmfMptSetCanTransfer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Whether the {@code tmfMPTClearCanTransfer} flag is set.
     *
     * @return {@code true} if set, otherwise {@code false}.
     */
    public boolean tmfMptClearCanTransfer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Whether the {@code tmfMPTSetCanClawback} flag is set.
     *
     * @return {@code true} if set, otherwise {@code false}.
     */
    public boolean tmfMptSetCanClawback() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Whether the {@code tmfMPTClearCanClawback} flag is set.
     *
     * @return {@code true} if set, otherwise {@code false}.
     */
    public boolean tmfMptClearCanClawback() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * A builder for {@link MpTokenIssuanceSetMutableFlags}.
     */
    public static class Builder {

        private boolean tmfMptSetCanLock = false;

        private boolean tmfMptClearCanLock = false;

        private boolean tmfMptSetRequireAuth = false;

        private boolean tmfMptClearRequireAuth = false;

        private boolean tmfMptSetCanEscrow = false;

        private boolean tmfMptClearCanEscrow = false;

        private boolean tmfMptSetCanTrade = false;

        private boolean tmfMptClearCanTrade = false;

        private boolean tmfMptSetCanTransfer = false;

        private boolean tmfMptClearCanTransfer = false;

        private boolean tmfMptSetCanClawback = false;

        private boolean tmfMptClearCanClawback = false;

        /**
         * Set {@code tmfMptSetCanLock}.
         *
         * @param value A boolean value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tmfMptSetCanLock(boolean value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set {@code tmfMptClearCanLock}.
         *
         * @param value A boolean value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tmfMptClearCanLock(boolean value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set {@code tmfMptSetRequireAuth}.
         *
         * @param value A boolean value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tmfMptSetRequireAuth(boolean value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set {@code tmfMptClearRequireAuth}.
         *
         * @param value A boolean value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tmfMptClearRequireAuth(boolean value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set {@code tmfMptSetCanEscrow}.
         *
         * @param value A boolean value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tmfMptSetCanEscrow(boolean value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set {@code tmfMptClearCanEscrow}.
         *
         * @param value A boolean value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tmfMptClearCanEscrow(boolean value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set {@code tmfMptSetCanTrade}.
         *
         * @param value A boolean value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tmfMptSetCanTrade(boolean value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set {@code tmfMptClearCanTrade}.
         *
         * @param value A boolean value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tmfMptClearCanTrade(boolean value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set {@code tmfMptSetCanTransfer}.
         *
         * @param value A boolean value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tmfMptSetCanTransfer(boolean value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set {@code tmfMptClearCanTransfer}.
         *
         * @param value A boolean value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tmfMptClearCanTransfer(boolean value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set {@code tmfMptSetCanClawback}.
         *
         * @param value A boolean value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tmfMptSetCanClawback(boolean value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set {@code tmfMptClearCanClawback}.
         *
         * @param value A boolean value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tmfMptClearCanClawback(boolean value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Build a new {@link MpTokenIssuanceSetMutableFlags} from the current boolean values.
         *
         * @return A new {@link MpTokenIssuanceSetMutableFlags}.
         */
        public MpTokenIssuanceSetMutableFlags build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
