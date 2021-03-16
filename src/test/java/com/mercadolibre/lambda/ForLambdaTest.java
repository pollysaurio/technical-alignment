package com.mercadolibre.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ForLambdaTest {

    private final List<String> languageList = Arrays.asList("node", "java", "python", "ruby");
    private final List<Long> longList = Arrays.asList(1L, 2L, 3L);

    @Test
    public void forExamples() {
        // for i
        for (int i=0; i < languageList.size(); i++) {
            System.out.println(languageList.get(i));
        }

        // foreach
        for (String language : languageList) {
            System.out.println(language);
        }

        // long lambda expression con una sola sentencia
        languageList.forEach(language -> System.out.println(language));

        // long lambda expression con varias sentencias
        languageList.forEach(language -> {
            System.out.println("voy a imprimir un lenguaje");
            System.out.println(language);
        });

        // short lambda expression
        languageList.forEach(System.out::println);
    }

    @Test
    public void forReference() {
        // PROJECT: Coverage
        // CLASS: CacheServiceTest
        // METHOD: getUtilities_creatingUtilityInCache
        languageList.forEach(this::printValue);
    }

    private void printValue(String value) {
        System.out.println("Vamo' a imprimir un lenguaje de programación: " + value);
    }


}
