package com.mercadolibre.lambda;

import com.google.gson.Gson;
import com.mercadolibre.dto.NodeDTO;
import com.mercadolibre.dto.PersonDTO;
import com.mercadolibre.dto.ResponseNodeDTO;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamFilterMap {

    private final List<PersonDTO> persons = Arrays.asList(
            new PersonDTO("Damian", 34),
            new PersonDTO("Caro", 24),
            new PersonDTO("Gus", 49)    // no le digan a Gus
    );

    @Test
    public void filterMapReturnString() {
        String filterName_1 = "Damian";

        String result = persons.stream()
                .map(PersonDTO::getName)            // convertimos el Stream en un String
                .filter(filterName_1::equals)       // aplicamos el filtro simplificado
                .findAny()
                .orElse("");

        System.out.println(result);

        List<String> collect = persons.stream()
                .map(PersonDTO::getName)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
    }

    @Test
    public void createHashMapMapFromList() {
        List<ResponseNodeDTO> responseNodeDTOList = Arrays.asList(
                createResponseNodeDTO(1L, "requestId_1", 200),
                createResponseNodeDTO(2L, "requestId_2", 500),
                createResponseNodeDTO(3L, "requestId_3", 404),
                createResponseNodeDTO(4L, "requestId_4", 200),
                createResponseNodeDTO(5L, "requestId_5", 500)
        );

        Map<String, NodeDTO> requestNodeMap = responseNodeDTOList.stream().collect(Collectors.toMap(
                ResponseNodeDTO::getRequest_id, ResponseNodeDTO::getNode
        ));
        System.out.println(requestNodeMap);

        Map<Long, NodeDTO> nodeIdNodeMap = responseNodeDTOList.stream().collect(Collectors.toMap(
                responseNodeDTO -> responseNodeDTO.getNode().getId(), ResponseNodeDTO::getNode
        ));
        System.out.println(nodeIdNodeMap);

        Map<Integer, List<ResponseNodeDTO>> statusResponseNodeListMap = responseNodeDTOList.stream().collect(
                Collectors.groupingBy(ResponseNodeDTO::getStatus)
        );
        System.out.println(statusResponseNodeListMap);

        Map<Integer, List<NodeDTO>> statusNodeListMap = responseNodeDTOList.stream().collect(
                Collectors.groupingBy(ResponseNodeDTO::getStatus,
                        Collectors.mapping(ResponseNodeDTO::getNode, Collectors.toList())
                )
        );
        System.out.println(statusNodeListMap);
    }

    /********* UTILS *********/

    public ResponseNodeDTO createResponseNodeDTO(Long id, String requestId, int status) {
        String StringJson = "{\n" +
                "   \"node\": {\n" +
                "       \"code\": \"SOY UN CODIGO COMPILABLE\",\n" +
                "       \"node_type\": \"decision\",\n" +
                "       \"date_create\": \"2020-08-25T14:30:31.000-04:00\",\n" +
                "       \"author\": \"dachavez\",\n" +
                "       \"user_last_modified\": \"dachavez\",\n" +
                "       \"description\": \"descripción\",\n" +
                "       \"id\": " + id + ",\n" +
                "       \"title\": \"title\",\n" +
                "       \"version\": 1,\n" +
                "       \"last_modified\": \"2020-09-29T13:44:44.000-04:00\"\n" +
                "   },\n" +
                "   \"request_id\": \"" + requestId + "\",\n" +
                "   \"status\":" + status +"\n" +
                "}\n";
        Gson gson = new Gson();
        return gson.fromJson(StringJson, ResponseNodeDTO.class);
    }

}
