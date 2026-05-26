package org.xrpl.xrpl4j.model.flags;

/*-
 * ========================LICENSE_START=================================
 * xrpl4j :: core
 * %%
 * Copyright (C) 2020 - 2023 XRPL Foundation and its contributors
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
import org.xrpl.xrpl4j.model.transactions.AccountSet;

/**
 * {@link TransactionFlags} for {@link AccountSet} transactions. Note that using these directly is discouraged, but can
 * be useful when setting multiple flags for an account.
 */
public class AccountSetTransactionFlags extends TransactionFlags {

    /**
     * Constant for an unset flag.
     */
    protected static final AccountSetTransactionFlags UNSET = new AccountSetTransactionFlags(0);

    /**
     * Constant for the {@code tfRequireDestTag} flag.
     */
    protected static final AccountSetTransactionFlags REQUIRE_DEST_TAG = new AccountSetTransactionFlags(0x00010000);

    /**
     * Constant for the {@code tfOptionalDestTag} flag.
     */
    protected static final AccountSetTransactionFlags OPTIONAL_DEST_TAG = new AccountSetTransactionFlags(0x00020000);

    /**
     * Constant for the {@code tfRequireAuth} flag.
     */
    protected static final AccountSetTransactionFlags REQUIRE_AUTH = new AccountSetTransactionFlags(0x00040000);

    /**
     * Constant for the {@code tfOptionalAuth} flag.
     */
    protected static final AccountSetTransactionFlags OPTIONAL_AUTH = new AccountSetTransactionFlags(0x00080000);

    /**
     * Constant for the {@code tfDisallowXRP} flag.
     */
    protected static final AccountSetTransactionFlags DISALLOW_XRP = new AccountSetTransactionFlags(0x00100000);

    /**
     * Constant for the {@code tfAllowXRP} flag.
     */
    protected static final AccountSetTransactionFlags ALLOW_XRP = new AccountSetTransactionFlags(0x00200000);

    /**
     * Constant {@link AccountSetTransactionFlags} for the {@code tfInnerBatchTxn} flag. This flag is used to indicate
     * that a transaction is an inner transaction of a Batch.
     *
     * @see "https://github.com/XRPLF/XRPL-Standards/tree/master/XLS-0056-batch"
     */
    public static final AccountSetTransactionFlags INNER_BATCH_TXN = new AccountSetTransactionFlags(TransactionFlags.INNER_BATCH_TXN.getValue());

    private AccountSetTransactionFlags(long value) {
        super(value);
    }

    private AccountSetTransactionFlags() {
    }

    private static AccountSetTransactionFlags of(boolean tfFullyCanonicalSig, boolean tfRequireDestTag, boolean tfOptionalDestTag, boolean tfRequireAuth, boolean tfOptionalAuth, boolean tfDisallowXrp, boolean tfAllowXrp, boolean tfInnerBatchTxn) {
        Preconditions.checkArgument(!(tfRequireDestTag && tfOptionalDestTag), "tfRequireDestTag and tfOptionalDestTag cannot both be set to true.");
        Preconditions.checkArgument(!(tfRequireAuth && tfOptionalAuth), "tfRequireAuth and tfOptionalAuth cannot both be set to true.");
        Preconditions.checkArgument(!(tfDisallowXrp && tfAllowXrp), "tfDisallowXrp and tfAllowXrp cannot both be set to true.");
        return new AccountSetTransactionFlags(Flags.of(tfFullyCanonicalSig ? TransactionFlags.FULLY_CANONICAL_SIG : UNSET, tfRequireDestTag ? REQUIRE_DEST_TAG : UNSET, tfOptionalDestTag ? OPTIONAL_DEST_TAG : UNSET, tfRequireAuth ? REQUIRE_AUTH : UNSET, tfOptionalAuth ? OPTIONAL_AUTH : UNSET, tfDisallowXrp ? DISALLOW_XRP : UNSET, tfAllowXrp ? ALLOW_XRP : UNSET, tfInnerBatchTxn ? TransactionFlags.INNER_BATCH_TXN : UNSET).getValue());
    }

    /**
     * Construct {@link AccountSetTransactionFlags} with a given value.
     *
     * @param value The long-number encoded flags value of this {@link AccountSetTransactionFlags}.
     *
     * @return New {@link AccountSetTransactionFlags}.
     */
    public static AccountSetTransactionFlags of(long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Construct an empty instance of {@link AccountSetTransactionFlags}. Transactions with empty flags will not be
     * serialized with a {@code Flags} field.
     *
     * @return An empty {@link AccountSetTransactionFlags}.
     */
    public static AccountSetTransactionFlags empty() {
        throw new UnsupportedOperationException("STUB: not implemented");
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
     * Require a fully canonical signature.
     *
     * @return {@code true} if {@code tfFullyCanonicalSig} is set, otherwise {@code false}.
     */
    public boolean tfFullyCanonicalSig() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Whether or not the {@code tfRequireDestTag} flag is set.
     *
     * @return {@code true} if {@code tfRequireDestTag} is set, otherwise {@code false}.
     */
    public boolean tfRequireDestTag() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Whether or not the {@code tfOptionalDestTag} flag is set.
     *
     * @return {@code true} if {@code tfOptionalDestTag} is set, otherwise {@code false}.
     */
    public boolean tfOptionalDestTag() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Whether or not the {@code tfRequireAuth} flag is set.
     *
     * @return {@code true} if {@code tfRequireAuth} is set, otherwise {@code false}.
     */
    public boolean tfRequireAuth() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Whether or not the {@code tfOptionalAuth} flag is set.
     *
     * @return {@code true} if {@code tfOptionalAuth} is set, otherwise {@code false}.
     */
    public boolean tfOptionalAuth() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Whether or not the {@code tfDisallowXrp} flag is set.
     *
     * @return {@code true} if {@code tfDisallowXrp} is set, otherwise {@code false}.
     */
    public boolean tfDisallowXrp() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Whether or not the {@code tfAllowXrp} flag is set.
     *
     * @return {@code true} if {@code tfAllowXrp} is set, otherwise {@code false}.
     */
    public boolean tfAllowXrp() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Indicates that this transaction is an inner transaction of a Batch transaction.
     *
     * @return {@code true} if {@code tfInnerBatchTxn} is set, otherwise {@code false}.
     *
     * @see "https://github.com/XRPLF/XRPL-Standards/tree/master/XLS-0056-batch"
     */
    public boolean tfInnerBatchTxn() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * A builder class for {@link AccountSetTransactionFlags}.
     */
    public static class Builder {

        private boolean tfRequireDestTag = false;

        private boolean tfOptionalDestTag = false;

        private boolean tfRequireAuth = false;

        private boolean tfOptionalAuth = false;

        private boolean tfDisallowXrp = false;

        private boolean tfAllowXrp = false;

        private boolean tfInnerBatchTxn = false;

        /**
         * Set {@code tfRequireDestTag} to the given value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tfRequireDestTag() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set {@code tfOptionalDestTag} to the given value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tfOptionalDestTag() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set {@code tfRequireAuth} to the given value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tfRequireAuth() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set {@code tfOptionalAuth} to the given value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tfOptionalAuth() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set {@code tfDisallowXrp} to the given value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tfDisallowXrp() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set {@code tfAllowXrp} to the given value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tfAllowXrp() {
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
         * Build a new {@link AccountSetTransactionFlags} from the current boolean values.
         *
         * @return A new {@link AccountSetTransactionFlags}.
         */
        public AccountSetTransactionFlags build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
