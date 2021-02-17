package com.mercadolibre.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;
import com.mercadolibre.dto.ResponseNodeDTO;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GsonTest {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public String gsonSerializeObject(Object object) {
        Gson gson = new GsonBuilder().registerTypeAdapter(
                Date.class, (JsonSerializer<Date>) (date, type, jsonSerializationContext) ->
                        new JsonPrimitive(sdf.format(date))
        ).create();
        return gson.toJson(object);
    }

    @Test
    public void testGsonLibrary() {
        String StringJson = "{\n" +
                "   \"node\": {\n" +
                "       \"code\": \"SOY UN CODIGO PYTHON COMPILABLE\",\n" +
                "       \"node_type\": \"decision\",\n" +
                "       \"date_create\": \"2020-08-25T14:30:31.000-04:00\",\n" +
                "       \"author\": \"dachavez\",\n" +
                "       \"user_last_modified\": \"dachavez\",\n" +
                "       \"description\": \"Válida si el zip code está activo\",\n" +
                "       \"id\": 405653097689,\n" +
                "       \"title\": \"ValidaStatusZipCode2\",\n" +
                "       \"version\": 21,\n" +
                "       \"last_modified\": \"2020-09-29T13:44:44.000-04:00\"\n" +
                "   },\n" +
                "   \"request_id\": \"c710de59-339f-4137-808a-db7b822f1e43\",\n" +
                "   \"status\": 200\n" +
                "}\n";

        Gson gson = new Gson();
        ResponseNodeDTO responseNodeDTO = gson.fromJson(StringJson, ResponseNodeDTO.class);
        String stringJson = gsonSerializeObject(responseNodeDTO);
    }

}
