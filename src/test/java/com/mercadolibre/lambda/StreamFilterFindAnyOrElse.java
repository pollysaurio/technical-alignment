package com.mercadolibre.lambda;

import com.mercadolibre.dto.PersonDTO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StreamFilterFindAnyOrElse {

    private final List<PersonDTO> persons = Arrays.asList(
            new PersonDTO("Damian", 34),
            new PersonDTO("Caro", 24),
            new PersonDTO("Gus", 49)    // no le digan a Gus
    );

    @Test
    public void filterFindAnyOrElseAndCollectBeforeJava8() {
        PersonDTO result = getPersonByName(persons, "Damian");
        System.out.println(result);
    }

    private PersonDTO getPersonByName(List<PersonDTO> persons, String name) {
        PersonDTO result = null;
        for (PersonDTO temp : persons) {
            if (name.equals(temp.getName())) {
                result = temp;
            }
        }
        return result;
    }

    @Test
    public void filterFindAnyOrElseAndCollectAfterJava8() {
        String filterName_1 = "Damian";

        PersonDTO result_1 = persons.stream()                                   // Convertimos la lista en Stream
                .filter(persona -> filterName_1.equals(persona.getName()))      // aplicamos el filtro
                .findAny()                                                      // si 'findAny' lo encontro retorna el objeto
                .orElse(null);                                            // si no encuentra ninguno returna null

        System.out.println(result_1);

        String filterName_2 = "lagertha";
        PersonDTO result_2 = persons.stream()
                .filter(persona -> filterName_2.equals(persona.getName()))
                .findAny()
                .orElse(null);

        System.out.println(result_2);
    }

    @Test
    public void filterFindAnyOrElseAndCollectAfterJava8_withMultipleCondition() {
        String filterName_1 = "Damian";

        PersonDTO result_1 = persons.stream()
                .filter(persona -> filterName_1.equals(persona.getName()) && persona.getAge() > 18)
                .findAny()
                .orElse(null);

        System.out.println(result_1);

        PersonDTO result_2 = persons.stream()
                .filter(persona -> {
                    if(filterName_1.equals(persona.getName())) {
                        System.out.println("Encontre a una persona que cumple con los filtros");
                        return true;
                    }
                    return false;
                })
                .findAny()
                .orElse(null);

        System.out.println(result_2);
    }

    @Test
    public void filterFindAnyOrElseAndCollectAfterJava8_withNonNull() {
        String filterName = "Ragnar";
        assertThrows(NullPointerException.class, () ->
                Objects.requireNonNull(
                        persons.stream()
                                .filter(persona -> filterName.equals(persona.getName()))
                                .findAny()
                                .orElse(null))
        );
    }

}
