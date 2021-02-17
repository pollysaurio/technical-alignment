package com.mercadolibre.controller;

import com.mercadolibre.dto.AnyDTO;
import com.mercadolibre.service.AnyService;
import com.mercadolibre.utils.AnyEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequestMapping(AnyEndpoint.BASE)
public class AnyController {

    private final AnyService anyService;

    public AnyController(AnyService anyService) {
        this.anyService = anyService;
    }

    @PostMapping(path = AnyEndpoint.POST_EXECUTE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AnyDTO postExecute(@RequestBody AnyDTO anyDTO) {
        anyService.postMethod(anyDTO);
        log.info("AnyDTO was processed successfully, anyDTO -> " + anyDTO.toString());
        return anyDTO;
    }

    @GetMapping(path = AnyEndpoint.GET_EXECUTE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AnyDTO getExecute(@RequestParam Long id) {
        AnyDTO anyDTO = null;
        try {
            anyDTO = anyService.getMethod(id);
            anyDTO.setName("DTO GET");
            log.info("AnyDTO was processed successfully, anyDTO -> " + anyDTO.toString());
        } catch (NullPointerException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AnyDTO Not Found", e);
        }
        return anyDTO;
    }

    @PutMapping (path = AnyEndpoint.PUT_EXECUTE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AnyDTO putExecute(@RequestBody AnyDTO anyDTO, @RequestParam Long id) {
        try {
            anyService.putMethod(anyDTO, id);
            log.info("AnyDTO was processed successfully, anyDTO -> " + anyDTO.toString());
            return anyDTO;
        } catch (NullPointerException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AnyDTO Not Found", e);
        }
    }

    @DeleteMapping (path = AnyEndpoint.DELETE_EXECUTE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteExecute(@RequestParam Long id) {
        boolean wasDeleted = anyService.deleteMethod(id);
        if (wasDeleted) {
            String response = "AnyDTO was deleted successfully ID -> " + id;
            log.info(response);
            return response;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AnyDTO Not Found");
        }
    }

}
