package org.xrpl.xrpl4j.model.jackson.modules;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xrpl.xrpl4j.model.ledger.UnknownLedgerObject;
import java.io.IOException;

/**
 * Custom Jackson deserializer for {@link UnknownLedgerObject}s. {@link UnknownLedgerObject} holds a {@link JsonNode}
 * of all the fields contained in the JSON being deserialized. However, we need this custom deserializer because the
 * {@link JsonNode} field is one level deeper than it is in the JSON.
 */
public class UnknownLedgerObjectDeserializer extends StdDeserializer<UnknownLedgerObject> {

    static Logger logger = LoggerFactory.getLogger(UnknownLedgerObjectDeserializer.class);

    protected UnknownLedgerObjectDeserializer() {
        super(UnknownLedgerObject.class);
    }

    @Override
    public UnknownLedgerObject deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JacksonException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
