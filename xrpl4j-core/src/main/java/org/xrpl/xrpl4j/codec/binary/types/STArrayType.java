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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableMap;
import org.xrpl.xrpl4j.codec.addresses.UnsignedByteArray;
import org.xrpl.xrpl4j.codec.binary.BinaryCodecObjectMapperFactory;
import org.xrpl.xrpl4j.codec.binary.definitions.FieldInstance;
import org.xrpl.xrpl4j.codec.binary.serdes.BinaryParser;
import org.xrpl.xrpl4j.codec.binary.serdes.BinarySerializer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Codec for XRPL STArray type.
 */
@SuppressWarnings("AbbreviationAsWordInName")
public class STArrayType extends SerializedType<STArrayType> {

    public static final String ARRAY_END_MARKER_HEX = "F1";

    public static final String ARRAY_END_MARKER_NAME = "ArrayEndMarker";

    public STArrayType() {
        this(UnsignedByteArray.empty());
    }

    public STArrayType(UnsignedByteArray list) {
        super(list);
    }

    @Override
    public STArrayType fromParser(BinaryParser parser) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public STArrayType fromJson(JsonNode node) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonNode toJson() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
