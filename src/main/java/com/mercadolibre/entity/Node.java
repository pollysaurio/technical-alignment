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
public class Node {

    private Long id;
    private Long version_id;
    private Integer edition_count;
    private String title;
    private String type;
    private String description;
    private String author;
    private Date date_created;
    private Date last_modified;
    private String user_last_modified;
    private String code;

}
