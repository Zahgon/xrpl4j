package org.xrpl.xrpl4j.model.transactions;

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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import org.immutables.value.Value;
import org.xrpl.xrpl4j.codec.addresses.UnsignedByteArray;
import org.xrpl.xrpl4j.crypto.keys.PublicKey;
import org.xrpl.xrpl4j.model.flags.BatchFlags;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A Batch transaction allows multiple transactions to be grouped together and executed atomically according to the
 * specified batch mode.
 *
 * <p>This class will be marked {@link Beta} until the featureBatch amendment is enabled on mainnet.
 * Its API is subject to change.</p>
 *
 * @see "https://github.com/XRPLF/XRPL-Standards/tree/master/XLS-0056-batch"
 */
@Value.Immutable
@JsonSerialize(as = ImmutableBatch.class)
@JsonDeserialize(as = ImmutableBatch.class)
@Beta
public interface Batch extends Transaction {

    /**
     * Construct a builder for this class.
     *
     * @return An {@link ImmutableBatch.Builder}.
     */
    static ImmutableBatch.Builder builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Set of {@link BatchFlags}s for this {@link Batch}, which define the batch execution mode.
     *
     * <p>Exactly one of the following modes must be set:
     * <ul>
     *   <li>{@link BatchFlags#ALL_OR_NOTHING} - All transactions must succeed, or all are reverted</li>
     *   <li>{@link BatchFlags#ONLY_ONE} - Only one transaction should succeed</li>
     *   <li>{@link BatchFlags#UNTIL_FAILURE} - Execute transactions until one fails</li>
     *   <li>{@link BatchFlags#INDEPENDENT} - Each transaction is independent</li>
     * </ul>
     *
     * @return The {@link BatchFlags} for this transaction.
     */
    @JsonProperty("Flags")
    @Value.Default
    default BatchFlags flags() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The list of inner transactions to be executed as part of this batch.
     *
     * <p>Must contain between 2 and 8 transactions (inclusive). Inner transactions must also have, among other rules:
     * <ul>
     *   <li>Have the {@code tfInnerBatchTxn} flag set</li>
     *   <li>Have a fee of "0" (fees are paid by the outer Batch transaction)</li>
     *   <li>Have an empty SigningPubKey and no TxnSignature</li>
     *   <li>Not be Batch transactions themselves (no nesting)</li>
     * </ul>
     *
     * @return A {@link List} of {@link RawTransactionWrapper} containing the inner transactions.
     *
     * @see "https://xls.xrpl.org/xls/XLS-0056-batch.html#23-failure-conditions"
     */
    @JsonProperty("RawTransactions")
    List<RawTransactionWrapper> rawTransactions();

    /**
     * Optional list of batch signers for multi-account batch transactions.
     *
     * <p>When inner transactions come from multiple accounts, each account must sign the batch
     * and provide their signature in this array.
     *
     * @return A {@link List} of {@link BatchSignerWrapper} containing the batch signers.
     */
    @JsonProperty("BatchSigners")
    List<BatchSignerWrapper> batchSigners();

    /**
     * Validates all properties of inner transactions in a single pass for efficiency. This combines multiple validations
     * to avoid iterating over rawTransactions multiple times.
     */
    @Value.Check
    default void checkRawTransactions() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Validates that exactly one batch mode flag is set.
     */
    @Value.Check
    default void checkBatchModeFlag() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Validates all BatchSigners-related constraints in a single pass for efficiency. This combines multiple validations
     * to avoid iterating over batchSigners and computing account sets multiple times.
     */
    @Value.Check
    default void checkBatchSigners() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
