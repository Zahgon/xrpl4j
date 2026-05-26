package org.xrpl.xrpl4j.codec.binary.types;

/*-
 * ========================LICENSE_START=================================
 * xrpl4j :: binary-codec
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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.xrpl.xrpl4j.codec.addresses.UnsignedByte;
import org.xrpl.xrpl4j.codec.addresses.UnsignedByteArray;
import org.xrpl.xrpl4j.codec.binary.BinaryCodecObjectMapperFactory;
import org.xrpl.xrpl4j.codec.binary.serdes.BinaryParser;

/**
 * Codec for XRPL Hop object inside a Path object.
 */
public class HopType extends SerializedType<HopType> {

    /**
     * Constant for masking types of a Hop.
     */
    public static final byte TYPE_ACCOUNT = 0x01;

    public static final byte TYPE_CURRENCY = 0x10;

    public static final byte TYPE_ISSUER = 0x20;

    private static final ObjectMapper objectMapper = BinaryCodecObjectMapperFactory.getObjectMapper();

    public HopType() {
        this(UnsignedByteArray.empty());
    }

    public HopType(UnsignedByteArray list) {
        super(list);
    }

    @Override
    public HopType fromParser(BinaryParser parser) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public HopType fromJson(JsonNode node) throws JsonProcessingException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonNode toJson() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
