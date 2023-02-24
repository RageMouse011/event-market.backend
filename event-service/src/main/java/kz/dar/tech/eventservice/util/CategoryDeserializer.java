package kz.dar.tech.eventservice.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import kz.dar.tech.eventservice.category.Category;

import java.io.IOException;

public class CategoryDeserializer extends JsonDeserializer<Category> {

    @Override
    public Category deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {

        String categoryString = jsonParser.getText().toLowerCase();
        try {
            return Category.valueOf(categoryString.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new JsonParseException(jsonParser, "Invalid category value: " + categoryString, e);
        }
    }
}
