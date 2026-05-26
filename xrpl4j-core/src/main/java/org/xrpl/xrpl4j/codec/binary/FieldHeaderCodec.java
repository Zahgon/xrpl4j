package org.xrpl.xrpl4j.codec.binary;

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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import org.xrpl.xrpl4j.codec.addresses.ByteUtils;
import org.xrpl.xrpl4j.codec.addresses.UnsignedByte;
import org.xrpl.xrpl4j.codec.binary.definitions.Definitions;
import org.xrpl.xrpl4j.codec.binary.definitions.DefinitionsProvider;
import org.xrpl.xrpl4j.codec.binary.definitions.FieldInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A codec for instances of {@link FieldHeader}.
 */
public class FieldHeaderCodec {

    private static final FieldHeaderCodec INSTANCE = new FieldHeaderCodec(DefinitionsProvider.getInstance().get(), BinaryCodecObjectMapperFactory.getObjectMapper());

    private final Definitions definitions;

    private final Map<String, FieldInfo> fieldMetadataMap;

    private final Map<FieldHeader, String> fieldIdNameMap;

    private final Map<String, Integer> typeOrdinalMap;

    /**
     * Required-args Constructor.
     *
     * @param definitions A {@link Definitions}.
     * @param mapper      An {@link ObjectMapper}.
     */
    public FieldHeaderCodec(Definitions definitions, ObjectMapper mapper) {
        this.definitions = definitions;
        this.fieldMetadataMap = new HashMap<>();
        this.fieldIdNameMap = new HashMap<>();
        this.typeOrdinalMap = definitions.types();
        this.definitions.fields().forEach(field -> {
            try {
                String fieldName = field.get(0).textValue();
                FieldInfo metadata = mapper.readValue(field.get(1).toString(), FieldInfo.class);
                FieldHeader fieldHeader = FieldHeader.builder().fieldCode(metadata.nth()).typeCode(typeOrdinalMap.get(metadata.type())).build();
                fieldMetadataMap.put(fieldName, metadata);
                fieldIdNameMap.put(fieldHeader, fieldName);
            } catch (JsonProcessingException e) {
                throw new IllegalArgumentException("invalid json", e);
            }
        });
    }

    public static FieldHeaderCodec getInstance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String encode(String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected String encode(FieldHeader fieldHeader) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String decode(String hex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected FieldHeader decodeFieldId(String hex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected FieldHeader getFieldId(String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
