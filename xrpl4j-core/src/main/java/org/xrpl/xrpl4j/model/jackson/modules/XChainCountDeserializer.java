package org.xrpl.xrpl4j.model.jackson.modules;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.google.common.primitives.UnsignedLong;
import org.xrpl.xrpl4j.model.transactions.VoteWeight;
import org.xrpl.xrpl4j.model.transactions.XChainClaimId;
import org.xrpl.xrpl4j.model.transactions.XChainCount;
import java.io.IOException;

/**
 * Custom Jackson deserializer for {@link VoteWeight}s.
 */
public class XChainCountDeserializer extends StdDeserializer<XChainCount> {

    /**
     * No-args constructor.
     */
    public XChainCountDeserializer() {
        super(XChainCount.class);
    }

    @Override
    public XChainCount deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
