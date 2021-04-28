package com.mercadolibre.service;

import com.mercadolibre.entity.Utility;

import java.util.Date;
import java.util.List;

public interface IUtilityService {

    Utility createUtility(Utility utility);
    Iterable<Utility> getAllUtilities();
    void deleteUtility(Long id);
    Utility getByName(String name);
    List<Utility> findAllByAuthorAndUserLastModified(String author, String userLastModified);
    List<Utility> findAllByDateCreatedBetween(Date dateCreatedStart, Date dateCreatedEnd);
    List<Utility> findAllWithDateCreatedAfter(Date dateCreated);
}
