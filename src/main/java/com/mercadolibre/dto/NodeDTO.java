package com.mercadolibre.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
@Builder
public class NodeDTO {

    private String code;
    private String node_type;
    private Date date_create;
    private String author;
    private String user_last_modified;
    private String description;
    private Long id;
    private String title;
    private Integer version;
    private Date last_modified;

}
