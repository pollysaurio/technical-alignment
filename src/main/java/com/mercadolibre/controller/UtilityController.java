package com.mercadolibre.controller;

import com.mercadolibre.entity.Utility;
import com.mercadolibre.service.IUtilityService;
import com.mercadolibre.service.impl.UtilityServiceImpl;
import com.mercadolibre.utils.UtilityEndpoint;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(UtilityEndpoint.BASE)
public class UtilityController {

    private final IUtilityService utilityService;

    public UtilityController(UtilityServiceImpl utilityService) {
        this.utilityService = utilityService;
    }

    @PostMapping(UtilityEndpoint.ADD)
    public @ResponseBody Utility createUtility(@RequestBody Utility utility) {
        return this.utilityService.createUtility(utility);
    }

    @GetMapping(UtilityEndpoint.ALL)
    public @ResponseBody Iterable<Utility> getAllUtilities() {
        return this.utilityService.getAllUtilities();
    }

    @DeleteMapping(UtilityEndpoint.DELETE)
    public void deleteUtility(@RequestParam Long id) {
        this.utilityService.deleteUtility(id);
    }

    @GetMapping(UtilityEndpoint.GET_BY_NAME)
    public @ResponseBody Utility getUtilityByName(@RequestParam String name) {
        return this.utilityService.getByName(name);
    }

    @GetMapping(UtilityEndpoint.GET_BY_AUTHOR_AND_USER_LAST_MODIFIED)
    public @ResponseBody List<Utility> findAllByAuthorAndUserLastModified(@RequestParam String author, @RequestParam String userLastModified) {
        return this.utilityService.findAllByAuthorAndUserLastModified(author, userLastModified);
    }

    // FORMAT DATE EXAMPLE IN URL -> dateCreated=2021-03-03T00:00:00
    @GetMapping(UtilityEndpoint.GET_BY_DATE_CREATED_AFTER)
    public @ResponseBody List<Utility> findAllWithDateCreatedAfter(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateCreated) {
        return this.utilityService.findAllWithDateCreatedAfter(dateCreated);
    }

    @GetMapping(UtilityEndpoint.GET_BY_DATE_CREATED_BETWEEN)
    public @ResponseBody List<Utility> findAllByDateCreatedBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateCreatedStart,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateCreatedEnd) {
        return this.utilityService.findAllByDateCreatedBetween(dateCreatedStart, dateCreatedEnd);
    }

}
