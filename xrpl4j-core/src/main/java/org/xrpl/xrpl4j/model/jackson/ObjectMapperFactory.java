package org.xrpl.xrpl4j.model.jackson;

/*-
 * ========================LICENSE_START=================================
 * xrpl4j :: model
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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ripple.cryptoconditions.jackson.CryptoConditionsModule;
import com.ripple.cryptoconditions.jackson.Encoding;
import org.xrpl.xrpl4j.model.jackson.modules.Xrpl4jModule;

/**
 * A factory for constructing instances of {@link ObjectMapper} for all xrpl4j-model components.
 */
public class ObjectMapperFactory {

    /**
     * Construct an {@link ObjectMapper} that can be used to serialize and deserialize JSON.
     *
     * @return An {@link ObjectMapper}.
     */
    public static ObjectMapper create() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
