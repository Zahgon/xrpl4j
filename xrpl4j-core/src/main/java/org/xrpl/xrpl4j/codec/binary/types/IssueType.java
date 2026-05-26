package org.xrpl.xrpl4j.codec.binary.types;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TextNode;
import org.xrpl.xrpl4j.codec.addresses.AddressCodec;
import org.xrpl.xrpl4j.codec.addresses.UnsignedByteArray;
import org.xrpl.xrpl4j.codec.binary.BinaryCodecObjectMapperFactory;
import org.xrpl.xrpl4j.codec.binary.serdes.BinaryParser;
import org.xrpl.xrpl4j.model.AddressConstants;
import java.util.regex.Pattern;

public class IssueType extends SerializedType<IssueType> {

    private static final ObjectMapper objectMapper = BinaryCodecObjectMapperFactory.getObjectMapper();

    private static final UnsignedByteArray ACCOUNT_ONE = AddressCodec.getInstance().decodeAccountId(AddressConstants.ACCOUNT_ONE);

    private static final Pattern MPT_ISSUANCE_ID_HEX_PATTERN = Pattern.compile("^[0-9A-Fa-f]{48}$");

    public IssueType() {
        this(UnsignedByteArray.ofSize(20));
    }

    public IssueType(UnsignedByteArray bytes) {
        super(bytes);
    }

    @Override
    public IssueType fromJson(JsonNode node) throws JsonProcessingException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IssueType fromParser(BinaryParser parser) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonNode toJson() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
