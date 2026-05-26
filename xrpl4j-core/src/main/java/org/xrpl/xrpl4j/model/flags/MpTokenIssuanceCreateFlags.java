package org.xrpl.xrpl4j.model.flags;

/**
 * A set of static {@link TransactionFlags} which can be set on
 * {@link org.xrpl.xrpl4j.model.transactions.MpTokenIssuanceCreate} transactions.
 */
@SuppressWarnings("abbreviationaswordinname")
public class MpTokenIssuanceCreateFlags extends TransactionFlags {

    /**
     * Constant {@link MpTokenIssuanceCreateFlags} for the {@code tfMPTCanLock} flag.
     */
    protected static final MpTokenIssuanceCreateFlags CAN_LOCK = new MpTokenIssuanceCreateFlags(0x00000002);

    /**
     * Constant {@link MpTokenIssuanceCreateFlags} for the {@code tfMPTRequireAuth} flag.
     */
    protected static final MpTokenIssuanceCreateFlags REQUIRE_AUTH = new MpTokenIssuanceCreateFlags(0x00000004);

    /**
     * Constant {@link MpTokenIssuanceCreateFlags} for the {@code tfMPTCanEscrow} flag.
     */
    protected static final MpTokenIssuanceCreateFlags CAN_ESCROW = new MpTokenIssuanceCreateFlags(0x00000008);

    /**
     * Constant {@link MpTokenIssuanceCreateFlags} for the {@code tfMPTCanTrade} flag.
     */
    protected static final MpTokenIssuanceCreateFlags CAN_TRADE = new MpTokenIssuanceCreateFlags(0x00000010);

    /**
     * Constant {@link MpTokenIssuanceCreateFlags} for the {@code tfMPTCanTransfer} flag.
     */
    protected static final MpTokenIssuanceCreateFlags CAN_TRANSFER = new MpTokenIssuanceCreateFlags(0x00000020);

    /**
     * Constant {@link MpTokenIssuanceCreateFlags} for the {@code tfMPTCanClawback} flag.
     */
    protected static final MpTokenIssuanceCreateFlags CAN_CLAWBACK = new MpTokenIssuanceCreateFlags(0x00000040);

    /**
     * Constant {@link MpTokenIssuanceCreateFlags} for the {@code tfInnerBatchTxn} flag.
     */
    public static final MpTokenIssuanceCreateFlags INNER_BATCH_TXN = new MpTokenIssuanceCreateFlags(TransactionFlags.INNER_BATCH_TXN.getValue());

    private MpTokenIssuanceCreateFlags(long value) {
        super(value);
    }

    private MpTokenIssuanceCreateFlags() {
    }

    /**
     * Create a new {@link Builder}.
     *
     * @return A new {@link Builder}.
     */
    public static Builder builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static MpTokenIssuanceCreateFlags of(boolean tfFullyCanonicalSig, boolean tfMPTCanLock, boolean tfMPTRequireAuth, boolean tfMPTCanEscrow, boolean tfMPTCanTrade, boolean tfMPTCanTransfer, boolean tfMPTCanClawback, boolean tfInnerBatchTxn) {
        return new MpTokenIssuanceCreateFlags(TransactionFlags.of(tfFullyCanonicalSig ? TransactionFlags.FULLY_CANONICAL_SIG : UNSET, tfMPTCanLock ? CAN_LOCK : UNSET, tfMPTRequireAuth ? REQUIRE_AUTH : UNSET, tfMPTCanEscrow ? CAN_ESCROW : UNSET, tfMPTCanTransfer ? CAN_TRANSFER : UNSET, tfMPTCanTrade ? CAN_TRADE : UNSET, tfMPTCanClawback ? CAN_CLAWBACK : UNSET, tfInnerBatchTxn ? INNER_BATCH_TXN : UNSET).getValue());
    }

    /**
     * Construct an empty instance of {@link MpTokenIssuanceCreateFlags}. Transactions with empty flags will not be
     * serialized with a {@code Flags} field.
     *
     * @return An empty {@link MpTokenIssuanceCreateFlags}.
     */
    public static MpTokenIssuanceCreateFlags empty() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * If set, indicates that the MPT can be locked both individually and globally. If not set, the MPT cannot be locked
     * in any way.
     *
     * @return {@code true} if {@code tfMPTCanLock} is set, otherwise {@code false}.
     */
    public boolean tfMptCanLock() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * If set, indicates that individual holders must be authorized. This enables issuers to limit who can hold their
     * assets.
     *
     * @return {@code true} if {@code tfMPTRequireAuth} is set, otherwise {@code false}.
     */
    public boolean tfMptRequireAuth() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * If set, indicates that individual holders can place their balances into an escrow.
     *
     * @return {@code true} if {@code tfMPTCanEscrow} is set, otherwise {@code false}.
     */
    public boolean tfMptCanEscrow() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * If set, indicates that individual holders can trade their balances using the XRP Ledger DEX.
     *
     * @return {@code true} if {@code tfMPTCanTrade} is set, otherwise {@code false}.
     */
    public boolean tfMptCanTrade() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * If set, indicates that tokens may be transferred by any account (issuer or non-issuer) to any account (issuer or
     * non-issuer). If unset, indicates that tokens may only be transferred from the issuer to any single account (or back
     * to the issuer) but that tokens may not be transferred between non-issuer accounts.
     *
     * @return {@code true} if {@code tfMPTCanTransfer} is set, otherwise {@code false}.
     */
    public boolean tfMptCanTransfer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * If set, indicates that the issuer may use the Clawback transaction to clawback value from individual holders.
     *
     * @return {@code true} if {@code tfMPTCanClawback} is set, otherwise {@code false}.
     */
    public boolean tfMptCanClawback() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Whether the {@code tfInnerBatchTxn} flag is set.
     *
     * @return {@code true} if {@code tfInnerBatchTxn} is set, otherwise {@code false}.
     */
    public boolean tfInnerBatchTxn() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * A builder class for {@link MpTokenIssuanceCreateFlags}.
     */
    public static class Builder {

        private boolean tfMptCanLock = false;

        private boolean tfMptRequireAuth = false;

        private boolean tfMptCanEscrow = false;

        private boolean tfMptCanTrade = false;

        private boolean tfMptCanTransfer = false;

        private boolean tfMptCanClawback = false;

        private boolean tfInnerBatchTxn = false;

        /**
         * Set {@code tfMptCanLock} to the given value.
         *
         * @param tfMptCanLock A boolean value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tfMptCanLock(boolean tfMptCanLock) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set {@code tfMptRequireAuth} to the given value.
         *
         * @param tfMptRequireAuth A boolean value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tfMptRequireAuth(boolean tfMptRequireAuth) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set {@code tfMptCanEscrow} to the given value.
         *
         * @param tfMptCanEscrow A boolean value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tfMptCanEscrow(boolean tfMptCanEscrow) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set {@code tfMptCanTrade} to the given value.
         *
         * @param tfMptCanTrade A boolean value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tfMptCanTrade(boolean tfMptCanTrade) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set {@code tfMptCanTransfer} to the given value.
         *
         * @param tfMptCanTransfer A boolean value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tfMptCanTransfer(boolean tfMptCanTransfer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set {@code tfMptCanClawback} to the given value.
         *
         * @param tfMptCanClawback A boolean value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tfMptCanClawback(boolean tfMptCanClawback) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set {@code tfInnerBatchTxn} to the given value.
         *
         * @param tfInnerBatchTxn A boolean value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tfInnerBatchTxn(boolean tfInnerBatchTxn) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Build a new {@link MpTokenIssuanceCreateFlags} from the current boolean values.
         *
         * @return A new {@link MpTokenIssuanceCreateFlags}.
         */
        public MpTokenIssuanceCreateFlags build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
