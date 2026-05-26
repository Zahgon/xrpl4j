package org.xrpl.xrpl4j.model.flags;

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
import org.xrpl.xrpl4j.model.ledger.RippleStateObject;

/**
 * A set of static {@link Flags} which can be set on {@link RippleStateObject}s.
 */
public class RippleStateFlags extends Flags {

    /**
     * Constant {@link RippleStateFlags} for the {@code lsfLowReserve} flag.
     */
    public static final RippleStateFlags LOW_RESERVE = new RippleStateFlags(0x00010000);

    /**
     * Constant {@link RippleStateFlags} for the {@code lsfHighReserve} flag.
     */
    public static final RippleStateFlags HIGH_RESERVE = new RippleStateFlags(0x00020000);

    /**
     * Constant {@link RippleStateFlags} for the {@code lsfLowAuth} flag.
     */
    public static final RippleStateFlags LOW_AUTH = new RippleStateFlags(0x00040000);

    /**
     * Constant {@link RippleStateFlags} for the {@code lsfHighAuth} flag.
     */
    public static final RippleStateFlags HIGH_AUTH = new RippleStateFlags(0x00080000);

    /**
     * Constant {@link RippleStateFlags} for the {@code lsfLowNoRipple} flag.
     */
    public static final RippleStateFlags LOW_NO_RIPPLE = new RippleStateFlags(0x00100000);

    /**
     * Constant {@link RippleStateFlags} for the {@code lsfHighNoRipple} flag.
     */
    public static final RippleStateFlags HIGH_NO_RIPPLE = new RippleStateFlags(0x00200000);

    /**
     * Constant {@link RippleStateFlags} for the {@code lsfLowFreeze} flag.
     */
    public static final RippleStateFlags LOW_FREEZE = new RippleStateFlags(0x00400000);

    /**
     * Constant {@link RippleStateFlags} for the {@code lsfHighFreeze} flag.
     */
    public static final RippleStateFlags HIGH_FREEZE = new RippleStateFlags(0x00800000);

    /**
     * Constant {@link RippleStateFlags} for the {@code lsfLowDeepFreeze} flag.
     */
    public static final RippleStateFlags LOW_DEEP_FREEZE = new RippleStateFlags(0x02000000);

    /**
     * Constant {@link RippleStateFlags} for the {@code lsfHighDeepFreeze} flag.
     */
    public static final RippleStateFlags HIGH_DEEP_FREEZE = new RippleStateFlags(0x04000000);

    private RippleStateFlags(long value) {
        super(value);
    }

    /**
     * Construct {@link RippleStateFlags} with a given value.
     *
     * @param value The long-number encoded flags value of this {@link RippleStateFlags}.
     *
     * @return New {@link RippleStateFlags}.
     */
    public static RippleStateFlags of(long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The corresponding {@link RippleStateObject}
     * <a href="https://xrpl.org/ripplestate.html#contributing-to-the-owner-reserve">contributes to the low
     * account's owner reserve</a>.
     *
     * @return {@code true} if {@code lsfLowReserve} is set, otherwise {@code false}.
     */
    public boolean lsfLowReserve() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The corresponding {@link RippleStateObject}
     * <a href="https://xrpl.org/ripplestate.html#contributing-to-the-owner-reserve">contributes to the high
     * account's owner reserve</a>.
     *
     * @return {@code true} if {@code lsfHighReserve} is set, otherwise {@code false}.
     */
    public boolean lsfHighReserve() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The low account has authorized the high account to hold the low account's issued currency.
     *
     * @return {@code true} if {@code lsfLowAuth} is set, otherwise {@code false}.
     */
    public boolean lsfLowAuth() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The high account has authorized the low account to hold the high account's issued currency.
     *
     * @return {@code true} if {@code lsfHighAuth} is set, otherwise {@code false}.
     */
    public boolean lsfHighAuth() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The low account has <a href="https://xrpl.org/rippling.html">disabled rippling</a> from this trust line.
     *
     * @return {@code true} if {@code lsfLowNoRipple} is set, otherwise {@code false}.
     */
    public boolean lsfLowNoRipple() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The high account has <a href="https://xrpl.org/rippling.html">disabled rippling</a> from this trust line.
     *
     * @return {@code true} if {@code lsfHighNoRipple} is set, otherwise {@code false}.
     */
    public boolean lsfHighNoRipple() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The low account has frozen the trust line, preventing the high account from transferring the asset.
     *
     * @return {@code true} if {@code lsfLowFreeze} is set, otherwise {@code false}.
     */
    public boolean lsfLowFreeze() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The high account has frozen the trust line, preventing the low account from transferring the asset.
     *
     * @return {@code true} if {@code lsfHighFreeze} is set, otherwise {@code false}.
     */
    public boolean lsfHighFreeze() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The low account has deep-frozen the trust line, preventing the high account from sending and receiving the asset.
     *
     * @return {@code true} if {@code lsfLowDeepFreeze} is set, otherwise {@code false}.
     */
    public boolean lsfLowDeepFreeze() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The high account has deep-frozen the trust line, preventing the low account from sending and receiving the asset.
     *
     * @return {@code true} if {@code lsfHighDeepFreeze} is set, otherwise {@code false}.
     */
    public boolean lsfHighDeepFreeze() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
