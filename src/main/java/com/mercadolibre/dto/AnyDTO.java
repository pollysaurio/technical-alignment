package com.mercadolibre.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AnyDTO implements Serializable {

    private static final long serialVersionUID = 4305105400894395748L;
    private String name;
    private Long id;
    private boolean processed;

}
