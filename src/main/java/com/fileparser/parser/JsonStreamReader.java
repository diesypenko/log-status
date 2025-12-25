package com.fileparser.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fileparser.model.Order;

public class JsonStreamReader implements OrderJsonParser {

    private final ObjectMapper mapper = new ObjectMapper();
	
    @Override
    public List<Order> parse(File file) throws ParserException {
        List<Order> result = new ArrayList<>();

        try (JsonParser parser = new JsonFactory().createParser(file)) {
            parser.setCodec(mapper);
            if (parser.nextToken() != JsonToken.START_ARRAY) {
                throw new ParserException("File must start with JSON array");
            }
            while (parser.nextToken() != JsonToken.END_ARRAY) {
                Order order = parser.readValueAs(Order.class);
                result.add(order);
            }
        } catch (Exception e) {
            throw new ParserException("Error parsing file: " + file.getName(), e);
        }

        return result;
    }

}
