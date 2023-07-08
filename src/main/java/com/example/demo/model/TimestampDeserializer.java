package com.example.demo.model;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampDeserializer extends JsonDeserializer<Timestamp> {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    @Override
    public Timestamp deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String timestampStr = parser.getValueAsString();
        try {
            Date date = dateFormat.parse(timestampStr);
            return new Timestamp(date.getTime());
        } catch (ParseException e) {
            throw new IOException("Failed to parse timestamp", e);
        }
    }
}