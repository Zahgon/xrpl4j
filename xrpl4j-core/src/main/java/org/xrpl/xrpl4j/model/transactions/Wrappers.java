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
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import com.google.common.primitives.UnsignedInteger;
import com.google.common.primitives.UnsignedLong;
import org.immutables.value.Value;
import org.immutables.value.Value.Default;
import org.xrpl.xrpl4j.model.immutables.FluentCompareTo;
import org.xrpl.xrpl4j.model.immutables.Wrapped;
import org.xrpl.xrpl4j.model.immutables.Wrapper;
import org.xrpl.xrpl4j.model.jackson.modules.AddressDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.AddressSerializer;
import org.xrpl.xrpl4j.model.jackson.modules.AssetPriceDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.AssetPriceSerializer;
import org.xrpl.xrpl4j.model.jackson.modules.AssetScaleDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.AssetScaleSerializer;
import org.xrpl.xrpl4j.model.jackson.modules.CredentialTypeDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.CredentialTypeSerializer;
import org.xrpl.xrpl4j.model.jackson.modules.CredentialUriDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.CredentialUriSerializer;
import org.xrpl.xrpl4j.model.jackson.modules.DidDataDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.DidDataSerializer;
import org.xrpl.xrpl4j.model.jackson.modules.DidDocumentDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.DidDocumentSerializer;
import org.xrpl.xrpl4j.model.jackson.modules.DidUriDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.DidUriSerializer;
import org.xrpl.xrpl4j.model.jackson.modules.Hash256Deserializer;
import org.xrpl.xrpl4j.model.jackson.modules.Hash256Serializer;
import org.xrpl.xrpl4j.model.jackson.modules.LoanBrokerDataDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.LoanBrokerDataSerializer;
import org.xrpl.xrpl4j.model.jackson.modules.LoanDataDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.LoanDataSerializer;
import org.xrpl.xrpl4j.model.jackson.modules.MarkerDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.MarkerSerializer;
import org.xrpl.xrpl4j.model.jackson.modules.MpTokenIssuanceIdDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.MpTokenIssuanceIdSerializer;
import org.xrpl.xrpl4j.model.jackson.modules.MpTokenMetadataDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.MpTokenMetadataSerializer;
import org.xrpl.xrpl4j.model.jackson.modules.MpTokenNumericAmountDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.MpTokenNumericAmountSerializer;
import org.xrpl.xrpl4j.model.jackson.modules.NetworkIdDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.NetworkIdSerializer;
import org.xrpl.xrpl4j.model.jackson.modules.NfTokenIdDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.NfTokenIdSerializer;
import org.xrpl.xrpl4j.model.jackson.modules.NfTokenUriSerializer;
import org.xrpl.xrpl4j.model.jackson.modules.OracleDocumentIdDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.OracleDocumentIdSerializer;
import org.xrpl.xrpl4j.model.jackson.modules.OracleProviderDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.OracleUriDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.TradingFeeDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.TradingFeeSerializer;
import org.xrpl.xrpl4j.model.jackson.modules.TransferFeeDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.TransferFeeSerializer;
import org.xrpl.xrpl4j.model.jackson.modules.VaultDataDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.VaultDataSerializer;
import org.xrpl.xrpl4j.model.jackson.modules.VoteWeightDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.VoteWeightSerializer;
import org.xrpl.xrpl4j.model.jackson.modules.XChainClaimIdDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.XChainClaimIdSerializer;
import org.xrpl.xrpl4j.model.jackson.modules.XChainCountDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.XChainCountSerializer;
import org.xrpl.xrpl4j.model.jackson.modules.XrpCurrencyAmountDeserializer;
import org.xrpl.xrpl4j.model.jackson.modules.XrpCurrencyAmountSerializer;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Objects;

/**
 * Wrapped immutable classes for providing type-safe objects.
 */
@SuppressWarnings("TypeName")
public class Wrappers {

    /**
     * A wrapped {@link String} representing an address on the XRPL.
     */
    // This is the default, but it's omitted without this.
    @Value.Immutable(builder = true)
    @Wrapped
    @JsonSerialize(as = Address.class, using = AddressSerializer.class)
    @JsonDeserialize(as = Address.class, using = AddressDeserializer.class)
    abstract static class _Address extends Wrapper<String> implements Serializable {

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Validates that a {@link Address}'s value's length is equal to 34 characters and starts with `r`.
         */
        @Value.Check
        public void validateAddress() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A wrapped {@link String} representing an X-Address on the XRPL.
     */
    // This is the default, but it's omitted without this.
    @Value.Immutable(builder = true)
    @Wrapped
    @JsonSerialize(as = XAddress.class)
    @JsonDeserialize(as = XAddress.class)
    abstract static class _XAddress extends Wrapper<String> implements Serializable {

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A wrapped {@link String} containing the Hex representation of a 256-bit Hash.
     */
    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = Hash256.class, using = Hash256Serializer.class)
    @JsonDeserialize(as = Hash256.class, using = Hash256Deserializer.class)
    abstract static class _Hash256 extends Wrapper<String> implements Serializable {

        /**
         * A {@link Hash256} containing all zeros.
         */
        static final Hash256 ZERO = Hash256.of("0000000000000000000000000000000000000000000000000000000000000000");

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Validates that a {@link Hash256}'s value's length is equal to 64 characters.
         */
        @Value.Check
        public void validateLength() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean equals(Object obj) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int hashCode() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A {@link CurrencyAmount} for the XRP currency (non-issued). {@link XrpCurrencyAmount}s are a {@link String}
     * representation of an unsigned integer representing the amount in XRP drops.
     */
    // This is the default, but it's omitted without this.
    @Value.Immutable(builder = true)
    @Wrapped
    @JsonSerialize(as = XrpCurrencyAmount.class, using = XrpCurrencyAmountSerializer.class)
    @JsonDeserialize(as = XrpCurrencyAmount.class, using = XrpCurrencyAmountDeserializer.class)
    abstract static class _XrpCurrencyAmount extends Wrapper<UnsignedLong> implements Serializable, CurrencyAmount {

        static final BigDecimal SMALLEST_XRP = new BigDecimal("0.000001");

        static final DecimalFormat FORMATTER = new DecimalFormat("###,###");

        /**
         * Constructs an {@link XrpCurrencyAmount} using a number of drops. Because XRP is capped to 100B units (1e17
         * drops), this value will never overflow Java's signed long number.
         *
         * @param drops A long representing the number of drops of XRP of this amount.
         *
         * @return An {@link XrpCurrencyAmount} of {@code drops}.
         */
        public static XrpCurrencyAmount ofDrops(final long drops) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Constructs an {@link XrpCurrencyAmount} using a number of drops.
         *
         * @param drops An {@link UnsignedLong} representing the number of drops of XRP of this amount.
         *
         * @return An {@link XrpCurrencyAmount} of {@code drops}.
         */
        public static XrpCurrencyAmount ofDrops(final UnsignedLong drops) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Constructs an {@link XrpCurrencyAmount} using a number of drops.
         *
         * @param drops      An {@link UnsignedLong} representing the number of drops of XRP of this amount.
         * @param isNegative Indicates whether this amount is positive or negative.
         *
         * @return An {@link XrpCurrencyAmount} of {@code drops}.
         */
        public static XrpCurrencyAmount ofDrops(final UnsignedLong drops, final boolean isNegative) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Constructs an {@link XrpCurrencyAmount} using decimal amount of XRP.
         *
         * @param amount A {@link BigDecimal} amount of XRP.
         *
         * @return An {@link XrpCurrencyAmount} of the amount of drops in {@code amount}.
         */
        public static XrpCurrencyAmount ofXrp(final BigDecimal amount) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Indicates whether this amount is positive or negative.
         *
         * <p>Note that the use of the `@Default` annotation and the default implementation are suitable for a few
         * reasons. First, deserialization will parse the payload properly, setting this value correctly (despite this
         * default annotation). Second, using a default value here will not break legacy code that uses a builder to
         * construct an {@link XrpCurrencyAmount} correctly (i.e., we assume that no developer is constructing a negative
         * XRP amount because the {@link UnsignedLong} precondition in any legacy code would not allow them to do such a
         * thing without throwing an exception). Finally, due to the way this class merely adds new static builders to
         * augment existing code, legacy code should continue to work normally.
         *
         * @return {@code true} if this amount is negative; {@code false} otherwise (i.e., if the value is 0 or positive).
         */
        @Default
        @Override
        public // any software using the JSON variant of an XrpCurrencyAmount will have this information available.
        boolean isNegative() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Indicates whether this amount is zero.
         *
         * @return {@code true} if this amount is zero; {@code false} otherwise.
         */
        @Override
        public boolean isZero() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Convert this XRP amount into a decimal representing a value denominated in whole XRP units. For example, a value
         * of `1.0` represents 1 unit of XRP; a value of `0.5` represents a half of an XRP unit.
         *
         * @return A {@link BigDecimal} representing this value denominated in whole XRP units.
         */
        public BigDecimal toXrp() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Adds another {@link XrpCurrencyAmount} to this amount.
         *
         * @param other An {@link XrpCurrencyAmount} to add to this.
         *
         * @return The sum of this amount and the {@code other} amount, as an {@link XrpCurrencyAmount}.
         */
        public XrpCurrencyAmount plus(XrpCurrencyAmount other) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Subtract another {@link XrpCurrencyAmount} from this amount.
         *
         * @param other An {@link XrpCurrencyAmount} to subtract from this.
         *
         * @return The difference of this amount and the {@code other} amount, as an {@link XrpCurrencyAmount}.
         */
        public XrpCurrencyAmount minus(XrpCurrencyAmount other) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Multiplies this amount by another {@link XrpCurrencyAmount}.
         *
         * @param other An {@link XrpCurrencyAmount} to multiply to this by.
         *
         * @return The product of this amount and the {@code other} amount, as an {@link XrpCurrencyAmount}.
         */
        public XrpCurrencyAmount times(final XrpCurrencyAmount other) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean equals(Object obj) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int hashCode() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Validates that this {@link XrpCurrencyAmount} does not exceed the maximum number of drops.
         */
        @Value.Check
        protected void check() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = Marker.class, using = MarkerSerializer.class)
    @JsonDeserialize(as = Marker.class, using = MarkerDeserializer.class)
    abstract static class _Marker extends Wrapper<String> implements Serializable {

        @Override
        @JsonRawValue
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A wrapped {@link String} containing the NFT Id.
     */
    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = NfTokenId.class, using = NfTokenIdSerializer.class)
    @JsonDeserialize(as = NfTokenId.class, using = NfTokenIdDeserializer.class)
    abstract static class _NfTokenId extends Wrapper<String> implements Serializable {

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Validates that a NfTokenId value's length is equal to 64 characters.
         */
        @Value.Check
        public void validateLength() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean equals(Object obj) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int hashCode() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A wrapped {@link String} containing the Uri.
     */
    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = NfTokenUri.class, using = NfTokenUriSerializer.class)
    @JsonDeserialize(as = NfTokenUri.class)
    abstract static class _NfTokenUri extends Wrapper<String> implements Serializable {

        /**
         * Constructs an {@link NfTokenUri} using a String value.
         *
         * @param plaintext A string value representing the Uri in plaintext.
         *
         * @return An {@link NfTokenUri} of plaintext.
         */
        public static NfTokenUri ofPlainText(String plaintext) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean equals(Object obj) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A wrapped {@link com.google.common.primitives.UnsignedInteger} containing the TransferFee.
     *
     * <p>Valid values for this field are between 0 and 50000 inclusive, allowing transfer rates of between 0.00% and
     * 50.00% in increments of 0.001. If this field is provided in a {@link NfTokenMint} transaction, the transaction MUST
     * have the {@code tfTransferable} flag enabled.
     */
    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = TransferFee.class, using = TransferFeeSerializer.class)
    @JsonDeserialize(as = TransferFee.class, using = TransferFeeDeserializer.class)
    abstract static class _TransferFee extends Wrapper<UnsignedInteger> implements Serializable {

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Construct {@link TransferFee} as a percentage value.
         *
         * <p>The given percentage value must have at most 3 decimal places of precision, and must be
         * between {@code 0} and {@code 50.000}.</p>
         *
         * @param percent of type {@link BigDecimal}
         *
         * @return {@link TransferFee}
         */
        public static TransferFee ofPercent(BigDecimal percent) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Validates that a NfTokenId value's length is equal to 64 characters.
         */
        @Value.Check
        public void validateBounds() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A wrapped {@link com.google.common.primitives.UnsignedInteger} containing a Network ID.
     */
    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = NetworkId.class, using = NetworkIdSerializer.class)
    @JsonDeserialize(as = NetworkId.class, using = NetworkIdDeserializer.class)
    abstract static class _NetworkId extends Wrapper<UnsignedInteger> implements Serializable {

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Construct a {@link NetworkId} from a {@code long}. The supplied value must be less than or equal to
         * 4,294,967,295, the largest unsigned 32-bit integer.
         *
         * @param networkId A {@code long}.
         *
         * @return A {@link NetworkId}.
         */
        public static NetworkId of(long networkId) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A wrapped {@link com.google.common.primitives.UnsignedInteger} containing the TransferFee.
     *
     * <p>This class will be marked {@link com.google.common.annotations.Beta} until the AMM amendment is enabled on
     * mainnet. Its API is subject to change.</p>
     */
    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = TradingFee.class, using = TradingFeeSerializer.class)
    @JsonDeserialize(as = TradingFee.class, using = TradingFeeDeserializer.class)
    @Beta
    abstract static class _TradingFee extends Wrapper<UnsignedInteger> implements Serializable {

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Construct {@link TradingFee} as a percentage value.
         *
         * @param percent The trading fee, as a {@link BigDecimal}.
         *
         * @return A {@link TradingFee}.
         */
        public static TradingFee ofPercent(BigDecimal percent) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Get the {@link TradingFee} as a {@link BigDecimal}.
         *
         * @return A {@link BigDecimal}.
         */
        public BigDecimal bigDecimalValue() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A wrapped {@link com.google.common.primitives.UnsignedInteger} containing the VoteWeight.
     *
     * <p>This class will be marked {@link com.google.common.annotations.Beta} until the AMM amendment is enabled on
     * mainnet. Its API is subject to change.</p>
     */
    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = VoteWeight.class, using = VoteWeightSerializer.class)
    @JsonDeserialize(as = VoteWeight.class, using = VoteWeightDeserializer.class)
    @Beta
    abstract static class _VoteWeight extends Wrapper<UnsignedInteger> implements Serializable {

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Get the {@link VoteWeight} as a {@link BigDecimal}.
         *
         * @return A {@link BigDecimal}.
         */
        public BigDecimal bigDecimalValue() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A wrapped {@link com.google.common.primitives.UnsignedLong} containing an XChainClaimID.
     *
     * <p>This class will be marked {@link com.google.common.annotations.Beta} until the featureXChainBridge amendment
     * is enabled on mainnet. Its API is subject to change.</p>
     */
    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = XChainClaimId.class, using = XChainClaimIdSerializer.class)
    @JsonDeserialize(as = XChainClaimId.class, using = XChainClaimIdDeserializer.class)
    @Beta
    abstract static class _XChainClaimId extends Wrapper<UnsignedLong> implements Serializable {

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A wrapped {@link com.google.common.primitives.UnsignedLong} representing a counter for XLS-38 sidechains. This
     * wrapper mostly exists to ensure we serialize fields of this type as a hex String in JSON, as these fields are
     * STUInt64s in rippled, which are hex encoded in JSON.
     *
     * <p>This class will be marked {@link com.google.common.annotations.Beta} until the featureXChainBridge amendment
     * is enabled on mainnet. Its API is subject to change.</p>
     */
    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = XChainCount.class, using = XChainCountSerializer.class)
    @JsonDeserialize(as = XChainCount.class, using = XChainCountDeserializer.class)
    @Beta
    abstract static class _XChainCount extends Wrapper<UnsignedLong> implements Serializable {

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A wrapped {@link String} containing a DID Document.
     *
     * <p>This class will be marked {@link com.google.common.annotations.Beta} until the featureDID amendment is
     * enabled on mainnet. Its API is subject to change.</p>
     */
    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = DidDocument.class, using = DidDocumentSerializer.class)
    @JsonDeserialize(as = DidDocument.class, using = DidDocumentDeserializer.class)
    @Beta
    abstract static class _DidDocument extends Wrapper<String> implements Serializable {

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A wrapped {@link String} containing a DID URI.
     *
     * <p>This class will be marked {@link com.google.common.annotations.Beta} until the featureDID amendment is
     * enabled on mainnet. Its API is subject to change.</p>
     */
    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = DidUri.class, using = DidUriSerializer.class)
    @JsonDeserialize(as = DidUri.class, using = DidUriDeserializer.class)
    @Beta
    abstract static class _DidUri extends Wrapper<String> implements Serializable {

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A wrapped {@link String} containing DID Data.
     *
     * <p>This class will be marked {@link com.google.common.annotations.Beta} until the featureDID amendment is
     * enabled on mainnet. Its API is subject to change.</p>
     */
    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = DidData.class, using = DidDataSerializer.class)
    @JsonDeserialize(as = DidData.class, using = DidDataDeserializer.class)
    @Beta
    abstract static class _DidData extends Wrapper<String> implements Serializable {

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A wrapped {@link UnsignedInteger} containing an Oracle document ID.
     *
     * <p>This class will be marked {@link com.google.common.annotations.Beta} until the featurePriceOracle amendment is
     * enabled on mainnet. Its API is subject to change.</p>
     */
    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = OracleDocumentId.class, using = OracleDocumentIdSerializer.class)
    @JsonDeserialize(as = OracleDocumentId.class, using = OracleDocumentIdDeserializer.class)
    @Beta
    abstract static class _OracleDocumentId extends Wrapper<UnsignedInteger> implements Serializable {

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A wrapped {@link String} containing an Oracle provider.
     *
     * <p>This class will be marked {@link com.google.common.annotations.Beta} until the featurePriceOracle amendment is
     * enabled on mainnet. Its API is subject to change.</p>
     */
    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = OracleProvider.class, using = ToStringSerializer.class)
    @JsonDeserialize(as = OracleProvider.class, using = OracleProviderDeserializer.class)
    @Beta
    abstract static class _OracleProvider extends Wrapper<String> implements Serializable {

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A wrapped {@link String} containing an Oracle URI.
     *
     * <p>This class will be marked {@link com.google.common.annotations.Beta} until the featurePriceOracle amendment is
     * enabled on mainnet. Its API is subject to change.</p>
     */
    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = OracleUri.class, using = ToStringSerializer.class)
    @JsonDeserialize(as = OracleUri.class, using = OracleUriDeserializer.class)
    @Beta
    abstract static class _OracleUri extends Wrapper<String> implements Serializable {

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A wrapped {@link String} containing an Oracle asset price.
     *
     * <p>This class will be marked {@link com.google.common.annotations.Beta} until the featurePriceOracle amendment is
     * enabled on mainnet. Its API is subject to change.</p>
     */
    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = AssetPrice.class, using = AssetPriceSerializer.class)
    @JsonDeserialize(as = AssetPrice.class, using = AssetPriceDeserializer.class)
    @Beta
    abstract static class _AssetPrice extends Wrapper<UnsignedLong> implements Serializable {

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = AssetScale.class, using = AssetScaleSerializer.class)
    @JsonDeserialize(as = AssetScale.class, using = AssetScaleDeserializer.class)
    @Beta
    abstract static class _AssetScale extends Wrapper<UnsignedInteger> implements Serializable {

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = MpTokenNumericAmount.class, using = MpTokenNumericAmountSerializer.class)
    @JsonDeserialize(as = MpTokenNumericAmount.class, using = MpTokenNumericAmountDeserializer.class)
    @Beta
    abstract static class _MpTokenNumericAmount extends Wrapper<UnsignedLong> implements Serializable {

        public static MpTokenNumericAmount of(long amount) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = MpTokenIssuanceId.class, using = MpTokenIssuanceIdSerializer.class)
    @JsonDeserialize(as = MpTokenIssuanceId.class, using = MpTokenIssuanceIdDeserializer.class)
    @Beta
    abstract static class _MpTokenIssuanceId extends Wrapper<String> implements Serializable {

        // TODO: Do clients ever need to construct an issuance id given a sequence and issuer AccountID?
        // See https://github.com/XRPLF/xrpl4j/issues/657
        @Value.Check
        void check() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean equals(Object obj) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int hashCode() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Wrapped String representing MPT metadata. This wrapper class may prove useful in the future if we ever want to
     * encapsulate various MPTokenMetadata standard formats.
     */
    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = MpTokenMetadata.class, using = MpTokenMetadataSerializer.class)
    @JsonDeserialize(as = MpTokenMetadata.class, using = MpTokenMetadataDeserializer.class)
    @Beta
    abstract static class _MpTokenMetadata extends Wrapper<String> implements Serializable {

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Base class for hex-encoded metadata wrappers with length validation.
     * Provides shared validation, equality, and string handling for metadata types.
     * Subclasses must override {@link #maxBytes()} to specify their size limit.
     */
    abstract static class Metadata extends Wrapper<String> implements Serializable {

        /**
         * Maximum allowed size in bytes.
         *
         * @return The maximum number of bytes allowed.
         */
        protected abstract UnsignedInteger maxBytes();

        /**
         * Validates that the value is not empty and does not exceed the maximum byte length.
         */
        @Value.Check
        public void validateLength() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Validates that the value is encoded in hexadecimal characters.
         */
        @Value.Check
        public void validateHexEncoding() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean equals(Object obj) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int hashCode() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A wrapped {@link String} containing vault metadata in hex format, limited to 256 bytes.
     *
     * <p>This class will be marked Beta until the SingleAssetVault amendment is enabled on mainnet. Its API is
     * subject to change.</p>
     */
    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = VaultData.class, using = VaultDataSerializer.class)
    @JsonDeserialize(as = VaultData.class, using = VaultDataDeserializer.class)
    @Beta
    abstract static class _VaultData extends Metadata {

        @Override
        protected UnsignedInteger maxBytes() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Constructs a {@link VaultData} from a plaintext string by hex-encoding it.
         *
         * @param plaintext A string value representing the vault data in plaintext.
         *
         * @return A {@link VaultData} of hex-encoded plaintext.
         */
        public static VaultData ofPlainText(String plaintext) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A wrapped {@link String} containing loan broker metadata in hex format, limited to 256 bytes.
     *
     * <p>This class will be marked Beta until the LendingProtocol amendment is enabled on mainnet. Its API is
     * subject to change.</p>
     */
    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = LoanBrokerData.class, using = LoanBrokerDataSerializer.class)
    @JsonDeserialize(as = LoanBrokerData.class, using = LoanBrokerDataDeserializer.class)
    @Beta
    abstract static class _LoanBrokerData extends Metadata {

        @Override
        protected UnsignedInteger maxBytes() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Constructs a {@link LoanBrokerData} from a plaintext string by hex-encoding it.
         *
         * @param plaintext A string value representing the loan broker data in plaintext.
         *
         * @return A {@link LoanBrokerData} of hex-encoded plaintext.
         */
        public static LoanBrokerData ofPlainText(String plaintext) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A wrapped {@link String} containing loan metadata in hex format, limited to 256 bytes.
     *
     * <p>This class will be marked Beta until the LendingProtocol amendment is enabled on mainnet. Its API is
     * subject to change.</p>
     */
    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = LoanData.class, using = LoanDataSerializer.class)
    @JsonDeserialize(as = LoanData.class, using = LoanDataDeserializer.class)
    @Beta
    abstract static class _LoanData extends Metadata {

        @Override
        protected UnsignedInteger maxBytes() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Constructs a {@link LoanData} from a plaintext string by hex-encoding it.
         *
         * @param plaintext A string value representing the loan data in plaintext.
         *
         * @return A {@link LoanData} of hex-encoded plaintext.
         */
        public static LoanData ofPlainText(String plaintext) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A wrapped {@link String} containing a Credential Type.
     */
    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = CredentialType.class, using = CredentialTypeSerializer.class)
    @JsonDeserialize(as = CredentialType.class, using = CredentialTypeDeserializer.class)
    @Beta
    abstract static class _CredentialType extends Wrapper<String> implements Serializable {

        /**
         * Constructs an {@link CredentialType} using a String value.
         *
         * @param plaintext A string value representing the Credential Type in plaintext.
         *
         * @return A {@link CredentialType} of plaintext.
         */
        public static CredentialType ofPlainText(String plaintext) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Validates that a {@link CredentialType}'s value's length is capped at 128 characters.
         */
        @Value.Check
        public void validateLength() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Validates that a {@link CredentialType}'s value is encoded in hexadecimal characters.
         */
        @Value.Check
        public void validateHexEncoding() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean equals(Object obj) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int hashCode() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A wrapped {@link String} containing a Credential Uri.
     */
    @Value.Immutable
    @Wrapped
    @JsonSerialize(as = CredentialUri.class, using = CredentialUriSerializer.class)
    @JsonDeserialize(as = CredentialUri.class, using = CredentialUriDeserializer.class)
    @Beta
    abstract static class _CredentialUri extends Wrapper<String> implements Serializable {

        /**
         * Constructs an {@link CredentialUri} using a String value.
         *
         * @param plaintext A string value representing the Uri in plaintext.
         *
         * @return An {@link CredentialUri} of plaintext.
         */
        public static CredentialUri ofPlainText(String plaintext) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Validates that a {@link CredentialUri}'s value's length is capped at 512 characters.
         */
        @Value.Check
        public void validateLength() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Validates that a {@link CredentialUri}'s value is encoded in hexadecimal characters.
         */
        @Value.Check
        public void validateHexEncoding() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean equals(Object obj) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int hashCode() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
