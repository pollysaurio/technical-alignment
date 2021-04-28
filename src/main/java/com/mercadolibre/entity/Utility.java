package com.mercadolibre.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="utility")
public class Utility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true, nullable=false)
    private String name;
    private String author;
    private Integer editionCount;
    private String description;
    private Date dateCreated;
    private Date lastModified;
    private String userLastModified;
    private Long repositoryId;
    private String utilityFileSha;

}
