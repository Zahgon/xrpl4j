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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import com.google.common.primitives.UnsignedInteger;
import com.google.common.primitives.UnsignedLong;
import com.ripple.cryptoconditions.Condition;
import com.ripple.cryptoconditions.CryptoConditionReader;
import com.ripple.cryptoconditions.CryptoConditionWriter;
import com.ripple.cryptoconditions.Fulfillment;
import com.ripple.cryptoconditions.PreimageSha256Fulfillment;
import com.ripple.cryptoconditions.der.DerEncodingException;
import org.immutables.value.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xrpl.xrpl4j.model.flags.TransactionFlags;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

/**
 * Deliver XRP, IOU tokens, or MPT tokens from a held payment to the recipient.
 *
 * <p>With the TokenEscrow amendment enabled, this transaction can finish escrows containing:
 * <ul>
 *   <li>XRP (as before)</li>
 *   <li>IOU tokens (trustline-based tokens)</li>
 *   <li>MPT tokens (Multi-Purpose Tokens)</li>
 * </ul>
 *
 * <p>Note: The transfer rate or transfer fee is locked at escrow creation time and applied during settlement,
 * even if the issuer changes the rate after the escrow was created.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableEscrowFinish.class)
@JsonDeserialize(as = ImmutableEscrowFinish.class)
public interface EscrowFinish extends Transaction {

    Logger logger = LoggerFactory.getLogger(EscrowFinish.class);

    /**
     * Construct a builder for this class.
     *
     * @return An {@link ImmutableEscrowFinish.Builder}.
     */
    static ImmutableEscrowFinish.Builder builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Compute the fee for the supplied {@code fulfillment}. The minimum transaction cost to submit an EscrowFinish
     * transaction increases if it contains a fulfillment. If the transaction contains a fulfillment, the transaction cost
     * is 330 drops of XRP plus another 10 drops for every 16 bytes in size of the preimage.
     *
     * @param currentLedgerBaseFeeDrops The number of drops that the ledger demands at present.
     * @param fulfillment               The {@link Fulfillment} that is being presented to the ledger for computation
     *                                  purposes.
     *
     * @return An {@link XrpCurrencyAmount} representing the computed fee.
     *
     * @see "https://xrpl.org/escrowfinish.html"
     */
    static XrpCurrencyAmount computeFee(final XrpCurrencyAmount currentLedgerBaseFeeDrops, final Fulfillment<?> fulfillment) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Set of {@link TransactionFlags}s for this {@link EscrowFinish}, which only allows the {@code tfFullyCanonicalSig}
     * flag, which is deprecated.
     *
     * <p>The value of the flags cannot be set manually, but exists for JSON serialization/deserialization only and for
     * proper signature computation in rippled.
     *
     * @return Always {@link TransactionFlags#EMPTY}.
     */
    @JsonProperty("Flags")
    @Value.Default
    default TransactionFlags flags() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@link Address} of the source account that funded the escrow payment.
     *
     * @return The {@link Address} of the source account.
     */
    @JsonProperty("Owner")
    Address owner();

    /**
     * The {@link EscrowCreate#sequence()} of the transaction that created the escrow to cancel.
     *
     * @return An {@link UnsignedInteger} representing the sequence number.
     */
    @JsonProperty("OfferSequence")
    UnsignedInteger offerSequence();

    /**
     * Hex value matching the previously-supplied PREIMAGE-SHA-256 crypto-condition of the held payment.
     *
     * <p>If this field is empty, developers should check if {@link #conditionRawValue()} is also empty. If
     * {@link #conditionRawValue()} is present, it means that the {@code "Condition"} field of the transaction was not a
     * well-formed crypto-condition but was still present in a transaction on ledger.</p>
     *
     * @return An {@link Optional} of type {@link Condition} containing the escrow condition.
     */
    @JsonIgnore
    Optional<Condition> condition();

    /**
     * The raw, hex-encoded PREIMAGE-SHA-256 crypto-condition of the escrow.
     *
     * <p>Developers should prefer setting {@link #condition()} and leaving this field empty when constructing a new
     * {@link EscrowFinish}. This field is used to serialize and deserialize the {@code "Condition"} field in JSON, the
     * XRPL will sometimes include an {@link EscrowFinish} in its ledger even if the crypto condition is malformed.
     * Without this field, xrpl4j would fail to deserialize those transactions, as {@link #condition()} is typed as a
     * {@link Condition}, which tries to decode the condition from DER.</p>
     *
     * <p>Note that a similar field does not exist on {@link EscrowCreate},
     * {@link org.xrpl.xrpl4j.model.ledger.EscrowObject}, or
     * {@link org.xrpl.xrpl4j.model.transactions.metadata.MetaEscrowObject} because {@link EscrowCreate}s with malformed
     * conditions will never be included in a ledger by the XRPL. Because of this fact, an
     * {@link org.xrpl.xrpl4j.model.ledger.EscrowObject} and
     * {@link org.xrpl.xrpl4j.model.transactions.metadata.MetaEscrowObject} will also never contain a malformed crypto
     * condition.</p>
     *
     * @return An {@link Optional} {@link String} containing the hex-encoded PREIMAGE-SHA-256 condition.
     */
    @JsonProperty("Condition")
    Optional<String> conditionRawValue();

    /**
     * Hex value of the PREIMAGE-SHA-256 crypto-condition fulfillment matching the held payment's {@link #condition()}.
     *
     * <p>If this field is empty, developers should check if {@link #fulfillmentRawValue()} is also empty. If
     * {@link #fulfillmentRawValue()} is present, it means that the {@code "Fulfillment"} field of the transaction was not
     * a well-formed crypto-condition fulfillment but was still present in a transaction on ledger.</p>
     *
     * @return An {@link Optional} of type {@link Fulfillment} containing the fulfillment for the escrow's condition.
     */
    @JsonIgnore
    Optional<Fulfillment<?>> fulfillment();

    /**
     * The raw, hex-encoded value of the PREIMAGE-SHA-256 crypto-condition fulfillment matching the held payment's
     * {@link #condition()}.
     *
     * <p>Developers should prefer setting {@link #fulfillment()} and leaving this field empty when constructing a new
     * {@link EscrowFinish}. This field is used to serialize and deserialize the {@code "Fulfillment"} field in JSON, the
     * XRPL will sometimes include an {@link EscrowFinish} in its ledger even if the crypto fulfillment is malformed.
     * Without this field, xrpl4j would fail to deserialize those transactions, as {@link #fulfillment()} is typed as a
     * {@link Fulfillment}, which tries to decode the fulfillment from DER.</p>
     *
     * @return An {@link Optional} {@link String} containing the hex-encoded PREIMAGE-SHA-256 fulfillment.
     */
    @JsonProperty("Fulfillment")
    Optional<String> fulfillmentRawValue();

    /**
     * Set of Credentials to authorize a deposit made by this transaction. Each member of the array must be the ledger
     * entry ID of a Credential entry in the ledger.
     *
     * @return A list of type {@link Hash256}.
     */
    @JsonProperty("CredentialIDs")
    List<Hash256> credentialIds();

    /**
     * Validate {@link EscrowFinish#credentialIds} has less than or equal to 8 credentials.
     */
    @Value.Check
    default void validateCredentialIdsLength() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Validate {@link EscrowFinish#credentialIds} are unique.
     */
    @Value.Check
    default void validateUniqueCredentialIds() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Normalization method to try to get {@link #condition()} and {@link #conditionRawValue()} to match.
     *
     * <p>If neither field is present, there is nothing to do.</p>
     * <p>If both fields are present, there is nothing to do, but we will check that {@link #condition()}'s
     * underlying value equals {@link #conditionRawValue()}.</p>
     * <p>If {@link #condition()} is present but {@link #conditionRawValue()} is empty, we set
     * {@link #conditionRawValue()} to the underlying value of {@link #condition()}.</p>
     * <p>If {@link #condition()} is empty and {@link #conditionRawValue()} is present, we will set
     * {@link #condition()} to the {@link Condition} representing the raw condition value, or leave {@link #condition()}
     * empty if {@link #conditionRawValue()} is a malformed {@link Condition}.</p>
     *
     * @return A normalized {@link EscrowFinish}.
     */
    @Value.Check
    default EscrowFinish normalizeCondition() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Normalization method to try to get {@link #fulfillment()} and {@link #fulfillmentRawValue()} to match.
     *
     * <p>If neither field is present, there is nothing to do.</p>
     * <p>If both fields are present, there is nothing to do, but we will check that {@link #fulfillment()}'s
     * underlying value equals {@link #fulfillmentRawValue()}.</p>
     * <p>If {@link #fulfillment()} is present but {@link #fulfillmentRawValue()} is empty, we set
     * {@link #fulfillmentRawValue()} to the underlying value of {@link #fulfillment()}.</p>
     * <p>If {@link #fulfillment()} is empty and {@link #fulfillmentRawValue()} is present, we will set
     * {@link #fulfillment()} to the {@link Fulfillment} representing the raw fulfillment value, or leave
     * {@link #fulfillment()} empty if {@link #fulfillmentRawValue()} is a malformed {@link Fulfillment}.</p>
     *
     * @return A normalized {@link EscrowFinish}.
     */
    @Value.Check
    default EscrowFinish normalizeFulfillment() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
