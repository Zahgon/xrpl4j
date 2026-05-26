package org.xrpl.xrpl4j.codec.binary.types;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.xrpl.xrpl4j.codec.addresses.UnsignedByte;
import org.xrpl.xrpl4j.codec.addresses.UnsignedByteArray;
import org.xrpl.xrpl4j.codec.binary.BinaryCodecObjectMapperFactory;
import org.xrpl.xrpl4j.codec.binary.serdes.BinaryParser;

public class XChainBridgeType extends SerializedType<XChainBridgeType> {

    private static final ObjectMapper objectMapper = BinaryCodecObjectMapperFactory.getObjectMapper();

    /**
     * XChainBridge typed fields are serialized by serializing the LockingChainDoor, LockingChainIssue, IssuingChainDoor
     * IssuingChainIssue fields in order without type or field codes. LockingChainDoor and IssuingChainDoor are an
     * {@link AccountIdType}, and LockingChainIssue and IssuingChainIssue are {@link IssueType}s.
     *
     * <p>The "empty" or "zero"
     * XChainBridge type has LockingChainDoor and IssuingChainDoor = ACCOUNT_ZERO, and LockingChainIssue and
     * IssuingChainIssue = XRP. AccountIDs are serialized with a length prefix, which is always {@code 0x14}. The XRP
     * issue is serialized as 160 zero bits. Therefore, the "zero" XChainBridge is {@code 0x14} followed by 20 zero bytes
     * for the LockingChainDoor, followed by 20 zero bytes for LockingChainIssue, followed by {@code 0x14} and 20 zero
     * bytes for the IssuingChainDoor and 20 zero bytes for IssuingChainIssue.</p>
     */
    private static final byte[] ZERO_XCHAIN_BRIDGE = new byte[82];

    static {
        ZERO_XCHAIN_BRIDGE[0] = 0x14;
        ZERO_XCHAIN_BRIDGE[41] = 0x14;
    }

    public XChainBridgeType() {
        this(UnsignedByteArray.of(ZERO_XCHAIN_BRIDGE));
    }

    public XChainBridgeType(UnsignedByteArray bytes) {
        super(bytes);
    }

    @Override
    public XChainBridgeType fromJson(JsonNode node) throws JsonProcessingException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public XChainBridgeType fromParser(BinaryParser parser) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonNode toJson() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
