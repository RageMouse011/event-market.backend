package kz.dar.tech.commentservice.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import kz.dar.tech.commentservice.document.Comment;

import java.io.IOException;

public class CommentSerializer extends JsonSerializer<Comment> {

    @Override
    public void serialize(
            Comment comment,
            JsonGenerator jsonGenerator,
            SerializerProvider serializerProvider
    )
            throws IOException
    {
        jsonGenerator.writeString((SerializableString) comment);
    }
}
