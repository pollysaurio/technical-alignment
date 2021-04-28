package com.mercadolibre.repository;

import com.mercadolibre.entity.Utility;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface UtilityRepository extends CrudRepository<Utility, Long> {

    Utility findByName(String name);
    List<Utility> findAllByAuthorAndUserLastModified(String author, String userLastModified);
    List<Utility> findAllByDateCreatedBetween(Date dateCreatedStart, Date dateCreatedEnd);

    @Query("SELECT u FROM utility u WHERE u.dateCreated >= :dateCreated")
    List<Utility> findAllWithDateCreatedAfter(@Param("dateCreated") Date dateCreated);

}
