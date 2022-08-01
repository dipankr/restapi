package com.restapi.json;

import org.junit.jupiter.api.Test;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

public class TestJsonParser {
    @Test
    void testMeow(){
        String ip = "{\"data\":[\"Cats have individual preferences for scratching surfaces and angles. " +
                    "Some are horizontal scratchers while others exercise their claws vertically.\"]}";

        JsonReader reader = Json.createReader(new StringReader(ip));
        JsonObject obj = reader.readObject();
        JsonArray arr = obj.getJsonArray("data");
        String data = arr.getString(0);
        System.out.println("data = " + data);
    }
}
