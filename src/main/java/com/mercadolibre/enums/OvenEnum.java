package com.mercadolibre.enums;

import lombok.*;

@AllArgsConstructor
@Getter
public enum OvenEnum {

    GAS(1, "gas"),
    ELECTRIC(2, "Electric"),
    CLAY(3, "Clay");

    private final int ovenId;
    private final String ovenType;

}
