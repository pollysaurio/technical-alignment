package com.mercadolibre.service.impl;

import com.mercadolibre.entity.Utility;
import com.mercadolibre.repository.UtilityRepository;
import com.mercadolibre.service.IUtilityService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UtilityServiceImpl implements IUtilityService {

    private final UtilityRepository utilityRepository;

    public UtilityServiceImpl(UtilityRepository utilityRepository) {
        this.utilityRepository = utilityRepository;
    }

    @Override
    public Utility createUtility(Utility utility) {
        return this.utilityRepository.save(utility);
    }

    @Override
    public Iterable<Utility> getAllUtilities() {
        return this.utilityRepository.findAll();
    }

    @Override
    public void deleteUtility(Long id) {
        this.utilityRepository.deleteById(id);
    }

    @Override
    public Utility getByName(String name) {
        return this.utilityRepository.findByName(name);
    }

    @Override
    public List<Utility> findAllByAuthorAndUserLastModified(String author, String userLastModified) {
        return this.utilityRepository.findAllByAuthorAndUserLastModified(author, userLastModified);
    }

    @Override
    public List<Utility> findAllByDateCreatedBetween(Date dateCreatedStart, Date dateCreatedEnd) {
        return this.utilityRepository.findAllByDateCreatedBetween(dateCreatedStart, dateCreatedEnd);
    }

    @Override
    public List<Utility> findAllWithDateCreatedAfter(Date dateCreated) {
        return this.utilityRepository.findAllWithDateCreatedAfter(dateCreated);
    }

}
