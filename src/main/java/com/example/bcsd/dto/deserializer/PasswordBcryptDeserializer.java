package com.example.bcsd.dto.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

public class PasswordBcryptDeserializer extends JsonDeserializer<String> {

    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String password = jsonParser.getValueAsString();

        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
