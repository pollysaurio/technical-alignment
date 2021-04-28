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
public class Repository {

    private Long id;
    private String token;
    private String name;
    private String repository_url;
    private Date date_created;
    private Date last_modified;
    private String user_last_modified;
    private String sha_master;
    private String owner;

}
