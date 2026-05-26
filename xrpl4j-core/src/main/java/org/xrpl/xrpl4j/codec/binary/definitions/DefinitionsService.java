package org.xrpl.xrpl4j.codec.binary.definitions;

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
import com.google.common.collect.ImmutableMap;
import org.xrpl.xrpl4j.codec.binary.BinaryCodecObjectMapperFactory;
import org.xrpl.xrpl4j.codec.binary.FieldHeader;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service for accessing XRPL type and field metadata from definitions.json.
 */
public class DefinitionsService {

    private static final DefinitionsService INSTANCE = new DefinitionsService(DefinitionsProvider.getInstance(), BinaryCodecObjectMapperFactory.getObjectMapper());

    private final Definitions definitions;

    private final Map<String, FieldInfo> fieldInfoMap;

    private final Map<FieldHeader, String> fieldIdNameMap;

    private final Map<String, Integer> typeOrdinalMap;

    private final Map<Integer, String> transactionTypeReverseLookupMap;

    private final Map<Integer, String> transactionResultReverseLookupNap;

    private final Map<Integer, String> ledgerEntryTypeReverseLookupMap;

    /**
     * Required-args Constructor.
     *
     * @param definitionsProvider A {@link DefinitionsProvider}.
     * @param mapper              An {@link ObjectMapper}.
     */
    DefinitionsService(DefinitionsProvider definitionsProvider, ObjectMapper mapper) {
        this.definitions = definitionsProvider.get();
        this.typeOrdinalMap = ImmutableMap.copyOf(definitions.types());
        Map<String, FieldInfo> tempFieldInfoMap = new HashMap<>();
        Map<FieldHeader, String> tempFieldIdNameMap = new HashMap<>();
        this.definitions.fields().forEach(field -> {
            try {
                String fieldName = field.get(0).textValue();
                FieldInfo metadata = mapper.readValue(field.get(1).toString(), FieldInfo.class);
                FieldHeader fieldHeader = FieldHeader.builder().fieldCode(metadata.nth()).typeCode(typeOrdinalMap.get(metadata.type())).build();
                tempFieldInfoMap.put(fieldName, metadata);
                tempFieldIdNameMap.put(fieldHeader, fieldName);
            } catch (JsonProcessingException e) {
                throw new IllegalArgumentException("invalid json", e);
            }
        });
        this.fieldInfoMap = ImmutableMap.copyOf(tempFieldInfoMap);
        this.fieldIdNameMap = ImmutableMap.copyOf(tempFieldIdNameMap);
        this.transactionTypeReverseLookupMap = inverse(definitions.transactionTypes());
        this.transactionResultReverseLookupNap = inverse(definitions.transactionResults());
        this.ledgerEntryTypeReverseLookupMap = inverse(definitions.ledgerEntryTypes());
    }

    /**
     * Obtain the JVM-wide instance of this {@link DefinitionsService}.
     *
     * @return A {@link DefinitionsService}.
     */
    public static DefinitionsService getInstance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Obtain the field name for the specified field header.
     *
     * @param fieldHeader A {@link FieldHeader}.
     *
     * @return A {@link String} representing the field name for the specified field header.
     */
    public String getFieldName(FieldHeader fieldHeader) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Obtain the field info for the specified field name.
     *
     * @param fieldName A {@link String} representing the field name.
     *
     * @return An optionally-present {@link FieldInfo}.
     */
    public Optional<FieldInfo> getFieldInfo(String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Obtain the type ordinal for the specified type name.
     *
     * @param typeName A {@link String} for the type name.
     *
     * @return An {@link Integer} representing the ordinal of the specified type name.
     */
    public Integer getTypeOrdinal(String typeName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Obtain an optionally-present field header with the specified field name.
     *
     * @param fieldName A {@link String} for the field header to obtain.
     *
     * @return An {@link Optional} of type {@link FieldHeader}.
     */
    public Optional<FieldHeader> getFieldHeader(String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Obtain an optionally-present field instance with the specified field header name.
     *
     * @param fieldName A {@link String} for the field instance to obtain.
     *
     * @return An {@link Optional} of type {@link FieldInstance}.
     */
    public Optional<FieldInstance> getFieldInstance(String fieldName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Obtain an optionally-present integer corresponding to the specified field name and value.
     *
     * @param fieldName A {@link String} representing the field name.
     * @param value     A {@link String} representing the value.
     *
     * @return An {@link Optional} of type {@link FieldInstance}.
     */
    public Optional<Integer> mapFieldSpecialization(String fieldName, String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Map a field's raw value to a specialied type.
     *
     * @param fieldName A {@link String} representing the name of the field to map.
     * @param value     A {@link String} value to map.
     *
     * @return An optionally-present {@link String} result.
     */
    public Optional<String> mapFieldRawValueToSpecialization(String fieldName, String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Map<Integer, String> inverse(Map<String, Integer> map) {
        return map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }
}
