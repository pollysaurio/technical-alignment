package com.mercadolibre.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class ResponseNodeDTO {

    private NodeDTO node;
    private String request_id;
    private Integer status;

}
