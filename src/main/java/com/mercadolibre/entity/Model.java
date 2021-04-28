package com.mercadolibre.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Model {

    private Long id;
    private String name;
    private String type;
    private String status;
    private Long bu_id;
    private String config;
    private Boolean is_active;
    private String description;
    private Date date_created;
    private Date last_modified;
    private String user_last_modified;

}
