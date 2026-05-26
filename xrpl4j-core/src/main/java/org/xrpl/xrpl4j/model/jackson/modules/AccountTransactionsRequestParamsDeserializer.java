package org.xrpl.xrpl4j.model.jackson.modules;

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
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.google.common.primitives.UnsignedInteger;
import org.xrpl.xrpl4j.model.client.accounts.AccountTransactionsRequestParams;
import org.xrpl.xrpl4j.model.client.accounts.ImmutableAccountTransactionsRequestParams;
import org.xrpl.xrpl4j.model.client.common.LedgerIndex;
import org.xrpl.xrpl4j.model.client.common.LedgerIndexBound;
import org.xrpl.xrpl4j.model.client.common.LedgerSpecifier;
import org.xrpl.xrpl4j.model.transactions.Address;
import org.xrpl.xrpl4j.model.transactions.Hash256;
import org.xrpl.xrpl4j.model.transactions.Marker;
import java.io.IOException;
import java.util.Optional;

/**
 * Custom deserializer for {@link AccountTransactionsRequestParams}. This is needed because Jackson cannot deserialize
 * {@link com.fasterxml.jackson.annotation.JsonUnwrapped} values if they are wrapped in an {@link Optional}, as is the
 * case with {@link AccountTransactionsRequestParams#ledgerSpecifier()}.
 */
public class AccountTransactionsRequestParamsDeserializer extends StdDeserializer<AccountTransactionsRequestParams> {

    /**
     * No-args constructor.
     */
    public AccountTransactionsRequestParamsDeserializer() {
        super(AccountTransactionsRequestParams.class);
    }

    @Override
    public AccountTransactionsRequestParams deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
