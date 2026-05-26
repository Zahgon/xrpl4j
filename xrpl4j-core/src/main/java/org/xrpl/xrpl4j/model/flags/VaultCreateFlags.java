package org.xrpl.xrpl4j.model.flags;

import com.google.common.annotations.Beta;
import org.xrpl.xrpl4j.model.transactions.VaultCreate;

/**
 * A set of static {@link TransactionFlags} which can be set on {@link VaultCreate} transactions.
 *
 * <p>This class will be marked {@link Beta} until the SingleAssetVault amendment is enabled on mainnet. Its API is
 * subject to change.</p>
 */
@Beta
public class VaultCreateFlags extends TransactionFlags {

    /**
     * Constant {@link VaultCreateFlags} for the {@code tfVaultPrivate} flag.
     */
    public static final VaultCreateFlags VAULT_PRIVATE = new VaultCreateFlags(0x00010000L);

    /**
     * Constant {@link VaultCreateFlags} for the {@code tfVaultShareNonTransferable} flag.
     */
    public static final VaultCreateFlags VAULT_SHARE_NON_TRANSFERABLE = new VaultCreateFlags(0x00020000L);

    private VaultCreateFlags(long value) {
        super(value);
    }

    private VaultCreateFlags() {
    }

    /**
     * Create a new {@link Builder}.
     *
     * @return A new {@link Builder}.
     */
    public static Builder builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Construct {@link VaultCreateFlags} with a given value.
     *
     * @param value The long-number encoded flags value of this {@link VaultCreateFlags}.
     *
     * @return New {@link VaultCreateFlags}.
     */
    public static VaultCreateFlags of(long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static VaultCreateFlags of(boolean tfFullyCanonicalSig, boolean tfVaultPrivate, boolean tfVaultShareNonTransferable) {
        long value = Flags.of(tfFullyCanonicalSig ? TransactionFlags.FULLY_CANONICAL_SIG : UNSET, tfVaultPrivate ? VAULT_PRIVATE : UNSET, tfVaultShareNonTransferable ? VAULT_SHARE_NON_TRANSFERABLE : UNSET).getValue();
        return new VaultCreateFlags(value);
    }

    /**
     * Construct an empty instance of {@link VaultCreateFlags}. Transactions with empty flags will not be serialized with
     * a {@code Flags} field.
     *
     * @return An empty {@link VaultCreateFlags}.
     */
    public static VaultCreateFlags empty() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * If enabled, the vault is private and requires a PermissionedDomain.
     *
     * @return {@code true} if {@code tfVaultPrivate} is set, otherwise {@code false}.
     */
    public boolean tfVaultPrivate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * If enabled, the vault shares (MPTokens) are non-transferable.
     *
     * @return {@code true} if {@code tfVaultShareNonTransferable} is set, otherwise {@code false}.
     */
    public boolean tfVaultShareNonTransferable() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * A builder class for {@link VaultCreateFlags} flags.
     */
    public static class Builder {

        private boolean tfVaultPrivate = false;

        private boolean tfVaultShareNonTransferable = false;

        /**
         * Set {@code tfVaultPrivate} to the given value.
         *
         * @param tfVaultPrivate A boolean value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tfVaultPrivate(boolean tfVaultPrivate) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set {@code tfVaultShareNonTransferable} to the given value.
         *
         * @param tfVaultShareNonTransferable A boolean value.
         *
         * @return The same {@link Builder}.
         */
        public Builder tfVaultShareNonTransferable(boolean tfVaultShareNonTransferable) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Build a new {@link VaultCreateFlags} from the current boolean values.
         *
         * @return A new {@link VaultCreateFlags}.
         */
        public VaultCreateFlags build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
