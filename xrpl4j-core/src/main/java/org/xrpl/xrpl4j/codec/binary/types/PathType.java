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
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.xrpl.xrpl4j.codec.addresses.UnsignedByteArray;
import org.xrpl.xrpl4j.codec.binary.BinaryCodecObjectMapperFactory;
import org.xrpl.xrpl4j.codec.binary.serdes.BinaryParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Codec for XRPL Path type inside a PathSet.
 */
public class PathType extends SerializedType<PathType> {

    /**
     * Constants for separating Paths in a PathSet.
     */
    public static final String PATHSET_END_HEX = "00";

    public static final String PATH_SEPARATOR_HEX = "FF";

    public PathType() {
        this(UnsignedByteArray.empty());
    }

    public PathType(UnsignedByteArray list) {
        super(list);
    }

    @Override
    public PathType fromParser(BinaryParser parser) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public PathType fromJson(JsonNode node) throws JsonProcessingException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public JsonNode toJson() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
