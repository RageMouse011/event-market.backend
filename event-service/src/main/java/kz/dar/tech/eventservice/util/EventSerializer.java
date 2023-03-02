package kz.dar.tech.eventservice.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import kz.dar.tech.eventservice.entity.Event;

import java.io.IOException;

public class EventSerializer extends JsonSerializer<Event> {

    @Override
    public void serialize(
            Event event,
            JsonGenerator jsonGenerator,
            SerializerProvider serializerProvider
    )
            throws IOException
    {
        jsonGenerator.writeString((SerializableString) event);
    }
}