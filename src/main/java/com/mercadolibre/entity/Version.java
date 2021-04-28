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
public class Version {

    private Long id;
    private Long model_id;
    private Integer version_number;
    private Integer edition_count;
    private String name;
    private String branch;
    private String commit;
    private String parent_id;
    private String models_sha;
    private String functions_sha;
    private String environment;
    private String description;
    private Date date_created;
    private Date last_modified;
    private String user_last_modified;

}
