package org.xrpl.xrpl4j.crypto.keys;

/*-
 * ========================LICENSE_START=================================
 * xrpl4j :: core
 * %%
 * Copyright (C) 2020 - 2023 XRPL Foundation and its contributors
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
import com.google.common.base.Preconditions;
import org.xrpl.xrpl4j.codec.addresses.UnsignedByteArray;
import org.xrpl.xrpl4j.crypto.SecureRandomUtils;
import java.util.Arrays;
import java.util.Objects;

/**
 * A compact value that is used to derive the actual private and public keys for an account.
 */
public class Entropy implements javax.security.auth.Destroyable {

    private final byte[] value;

    private boolean destroyed;

    /**
     * Construct a new instance of an {@link Entropy}.
     *
     * @return An {@link Entropy}.
     */
    public static Entropy newInstance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Construct a new instance of an {@link Entropy} from the supplied byte array.
     *
     * @param entropy An array of bytes.
     *
     * @return An {@link Entropy}.
     */
    public static Entropy of(final byte[] entropy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Required-args constructor.
     *
     * @param entropy An byte array containing random values.
     */
    private Entropy(final byte[] entropy) {
        Objects.requireNonNull(entropy);
        Preconditions.checkArgument(entropy.length == 16, "Entropy must be 16 bytes");
        final byte[] copiedEntropy = new byte[entropy.length];
        System.arraycopy(entropy, 0, copiedEntropy, 0, entropy.length);
        this.value = copiedEntropy;
    }

    /**
     * Accessor for a copy of the value of this seed.
     *
     * @return An instance of {@link UnsignedByteArray}.
     */
    public UnsignedByteArray value() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final void destroy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final boolean isDestroyed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
