package com.mercadolibre.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterCollect {

    private final List<String> namesList = Arrays.asList("Caro", "Cami", "Jose", "Dami", "Ruben", "Gus");

    @Test
    public void filterAndCollectBeforeJava8() {
        List<String> result = filter(namesList, "Ruben");
        for (String temp : result) {
            System.out.println(temp);
        }
    }

    private List<String> filter(List<String> values, String filterValue) {
        List<String> result = new ArrayList<>();
        for (String value : values) {
            if (!filterValue.equals(value)) {
                result.add(value);
            }
        }
        return result;
    }

    @Test
    public void filterAndCollectAfterJava8() {
        String filterName = "Gus";

        List<String> result = namesList.stream()            // Convertimos la lista en Stream
                .filter(line -> !filterName.equals(line))   // aplicamos el filtro
                .collect(Collectors.toList());              // recolectamos la salida y convertimos el stream en una lista

        result.forEach(System.out::println);
    }

}
