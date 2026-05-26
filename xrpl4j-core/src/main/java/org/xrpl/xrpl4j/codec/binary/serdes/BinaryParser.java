package org.xrpl.xrpl4j.codec.binary.serdes;

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
import com.google.common.primitives.UnsignedLong;
import org.xrpl.xrpl4j.codec.addresses.ByteUtils;
import org.xrpl.xrpl4j.codec.addresses.UnsignedByte;
import org.xrpl.xrpl4j.codec.addresses.UnsignedByteArray;
import org.xrpl.xrpl4j.codec.binary.FieldHeader;
import org.xrpl.xrpl4j.codec.binary.definitions.DefinitionsService;
import org.xrpl.xrpl4j.codec.binary.definitions.FieldInstance;
import org.xrpl.xrpl4j.codec.binary.types.FieldWithValue;
import org.xrpl.xrpl4j.codec.binary.types.SerializedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Parser for XRPL binary hex values.
 */
public class BinaryParser {

    // max length that can be represented in a single byte per XRPL serialization restrictions
    public static final int MAX_SINGLE_BYTE_LENGTH = 192;

    // max length that can be represented in 2 bytes per XRPL serialization restrictions
    public static final int MAX_DOUBLE_BYTE_LENGTH = 12481;

    // max value that can be used in the second byte of a length field
    public static final int MAX_SECOND_BYTE_VALUE = 240;

    // max value that can be represented using one 8-bit byte
    public static final int MAX_BYTE_VALUE = 256;

    // max value that can be represented in using two 8-bit bytes
    public static final int MAX_DOUBLE_BYTE_VALUE = 65536;

    // 1 byte encodes to 2 characters in hex
    private static final int BYTE_HEX_LENGTH = 2;

    private final String hex;

    private int cursor = 0;

    public BinaryParser(String hex) {
        this.hex = hex;
    }

    public UnsignedByte peek() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void skip(int bytesToSkip) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Read from this parser.
     *
     * @param bytesToRead An int representing the number of bytes to read.
     *
     * @return An {@link UnsignedByteArray}.
     */
    public UnsignedByteArray read(int bytesToRead) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UnsignedLong readUInt8() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UnsignedLong readUInt16() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UnsignedLong readUInt32() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UnsignedLong readUInt64() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int size() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean hasMore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads the length of the variable length encoded bytes.
     *
     * @return The length of the variable length encoded bytes.
     */
    public int readVariableLengthLength() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads the field ordinal from the BinaryParser.
     *
     * @return Field ordinal.
     */
    public FieldHeader readFieldHeader() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Read the field from the BinaryParser.
     *
     * @return The field represented by the bytes at the head of the BinaryParser.
     */
    public Optional<FieldInstance> readField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Read a given type from the BinaryParser.
     *
     * @param type The type that you want to read from the BinaryParser.
     * @param <T>  A {@link SerializedType} to read as.
     *
     * @return The instance of the type read from the BinaryParser.
     */
    public <T extends SerializedType<T>> T readType(Class<T> type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get the type associated with a given field.
     *
     * @param field The field that you wan to get the type of.
     *
     * @return The type associated with the given field.
     */
    public SerializedType typeForField(FieldInstance field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Read value of the type specified by field from the BinaryParser.
     *
     * @param field The field that you want to get the associated value for.
     *
     * @return The value associated with the given field.
     */
    public SerializedType readFieldValue(final FieldInstance field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get the next field and value from the BinaryParser.
     *
     * @return The field and value.
     */
    public Optional<FieldWithValue> readFieldAndValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private UnsignedLong readUInt(int bytes) {
        return ByteUtils.toUnsignedLong(read(bytes));
    }
}
