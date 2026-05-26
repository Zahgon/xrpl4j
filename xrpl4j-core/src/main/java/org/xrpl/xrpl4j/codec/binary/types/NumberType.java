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
import com.fasterxml.jackson.databind.node.TextNode;
import com.google.common.base.Strings;
import org.xrpl.xrpl4j.codec.addresses.UnsignedByteArray;
import org.xrpl.xrpl4j.codec.binary.serdes.BinaryParser;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Objects;

public class NumberType extends SerializedType<NumberType> {

    /**
     * The fixed width of a serialized Number in bytes (8 for mantissa + 4 for exponent).
     */
    public static final int WIDTH = 12;

    // 10^18
    private static final BigInteger MIN_MANTISSA = new BigInteger("1000000000000000000");

    // 10^19 - 1
    private static final BigInteger MAX_MANTISSA = new BigInteger("9999999999999999999");

    // 2^63 - 1
    private static final BigInteger MAX_INT64 = new BigInteger("9223372036854775807");

    private static final int MIN_EXPONENT = -32768;

    private static final int MAX_EXPONENT = 32768;

    private static final int DEFAULT_VALUE_EXPONENT = Integer.MIN_VALUE;

    public NumberType() {
        this(UnsignedByteArray.ofSize(WIDTH));
    }

    public NumberType(UnsignedByteArray bytes) {
        super(bytes);
    }

    @Override
    public NumberType fromParser(final BinaryParser parser) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // xrpld implementation: src/libxrpl/basics/Number.cpp -> doNormalize
    @Override
    public NumberType fromJson(final JsonNode node) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // xrpld implementation: src/libxrpl/basics/Number.cpp -> to_string
    @Override
    public JsonNode toJson() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
