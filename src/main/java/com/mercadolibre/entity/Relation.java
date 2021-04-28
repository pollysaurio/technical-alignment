package com.mercadolibre.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Relation {

    private Long id;
    private Long version_id;
    private Long node_id;
    private Double position_x;
    private Double position_y;
    private Long left_child;
    private Long right_child;
    private Long node_position;
    private String user_last_modified;
    private Date last_modified;
    private Date date_created;

}
