package org.xrpl.xrpl4j.model.jackson.modules;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;
import org.xrpl.xrpl4j.model.transactions.AssetPrice;
import java.io.IOException;

/**
 * Custom Jackson serializer for {@link AssetPrice}s.
 */
public class AssetPriceSerializer extends StdScalarSerializer<AssetPrice> {

    /**
     * No-args constructor.
     */
    public AssetPriceSerializer() {
        super(AssetPrice.class, false);
    }

    @Override
    public void serialize(AssetPrice count, JsonGenerator gen, SerializerProvider provider) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
