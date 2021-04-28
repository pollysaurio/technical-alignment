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
public class Function {

    private Long id;
    private Long version_id;
    private String title;
    private String author;
    private Integer edition_count;
    private String description;
    private Date date_created;
    private Date last_modified;
    private String user_last_modified;

}
