package org.xrpl.xrpl4j.codec.binary.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import org.immutables.value.Value;
import java.util.Optional;

/**
 * JSON mapping object for the Issue serializable type. Handles XRP, IOU, and MPT assets.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableIssue.class)
@JsonDeserialize(as = ImmutableIssue.class)
public interface Issue {

    /**
     * Construct a {@code Issue} builder.
     *
     * @return An {@link ImmutableIssue.Builder}.
     */
    static ImmutableIssue.Builder builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The currency code of the Issue. Present for XRP and IOU assets.
     *
     * @return An optionally present {@link JsonNode} containing the currency code.
     */
    Optional<JsonNode> currency();

    /**
     * The address of the issuer of this currency. Present for IOU assets.
     *
     * @return An optionally present {@link JsonNode}.
     */
    Optional<JsonNode> issuer();

    /**
     * The MPT issuance ID. Present for MPT assets.
     *
     * @return An optionally present {@link JsonNode}.
     */
    @JsonProperty("mpt_issuance_id")
    Optional<JsonNode> mptIssuanceId();

    /**
     * Validate that the Issue fields are consistent.
     */
    @Value.Check
    default void checkFields() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
