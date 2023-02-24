package kz.dar.tech.eventloadingservice.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import kz.dar.tech.eventloadingservice.dto.Category;

import java.io.IOException;

public class CategorySerializer extends JsonSerializer<Category> {

    @Override
    public void serialize(
            Category category,
            JsonGenerator jsonGenerator,
            SerializerProvider serializerProvider
    )
            throws IOException
    {
        jsonGenerator.writeString(category.name().toLowerCase());
    }
}
