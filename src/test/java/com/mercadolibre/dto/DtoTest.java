package com.mercadolibre.dto;

import org.junit.Test;

public class DtoTest {

    @Test
    public void testingDTONoArgsConstruct() {
        AnyDTO anyDTO = new AnyDTO();
    }

    @Test
    public void testingDTOAllArgsConstruct() {
        String name = "name";
        Long id = 12234L;
        boolean processed = Boolean.TRUE;
        AnyDTO anyDTO = new AnyDTO(name, id, processed);
    }

    @Test
    public void testingDTOBuilder() {
        String name = "name";
        Long id = 12234L;
        boolean processed = Boolean.TRUE;
        AnyDTO anyDTO_1 = AnyDTO.builder()
                .name(name)
                .id(id)
                .processed(processed)
                .build();

        AnyDTO anyDTO_2 = AnyDTO.builder()
                .name(name)
                .id(id)
                .build();
    }

    @Test
    public void testingDTOData() {
        String name = "name";
        Long id = 12234L;
        AnyDTO anyDTO = new AnyDTO(name, id, Boolean.TRUE);
        System.out.println("AnyDTO toString() -> " + anyDTO.toString());
    }

}
