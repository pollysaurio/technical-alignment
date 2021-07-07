package com.mercadolibre.controller;

import com.mercadolibre.dto.AnyDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@RestController
@RequestMapping("/async")
public class AsyncController {

    @GetMapping(path = "/execute_async", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AnyDTO getExecute() {
        log.info("Inicio - {}", new Date());
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        log.info("Creando runnable");
        AsyncRunnable runnable = new AsyncRunnable();
        log.info("Invocando al executorService");
        executorService.execute(runnable);
        log.info("executorService invocado");

        AnyDTO anyDTO = new AnyDTO();
        try {
            anyDTO.setName("Todo jamon");
        } catch (NullPointerException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AnyDTO Not Found", e);
        }
        log.info("Fin - {}", new Date());
        return anyDTO;
    }

    private class AsyncRunnable implements Runnable {
        @Override
        public void run() {
            try {
                log.info("Runnable inicio de ejecución - {}", new Date());
                ExecutorService executorService = Executors.newFixedThreadPool(5);

                Thread.sleep(10000);
                log.info("Runnable fin de ejecucion - {}", new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
