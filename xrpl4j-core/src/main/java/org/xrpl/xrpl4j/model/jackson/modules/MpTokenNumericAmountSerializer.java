package org.xrpl.xrpl4j.model.jackson.modules;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;
import org.xrpl.xrpl4j.model.transactions.MpTokenNumericAmount;
import java.io.IOException;

/**
 * Custom Jackson serializer for {@link MpTokenNumericAmount}s.
 */
public class MpTokenNumericAmountSerializer extends StdScalarSerializer<MpTokenNumericAmount> {

    /**
     * No-args constructor.
     */
    public MpTokenNumericAmountSerializer() {
        super(MpTokenNumericAmount.class, false);
    }

    @Override
    public void serialize(MpTokenNumericAmount count, JsonGenerator gen, SerializerProvider provider) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
