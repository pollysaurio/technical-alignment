package com.mercadolibre.service.impl;

import com.mercadolibre.dto.PizzaDTO;
import com.mercadolibre.service.IOven;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OvenClayImpl implements IOven {

    @Override
    public void cook(PizzaDTO pizzaDTO) {
        log.info("Cooking a pizza with clay oven");
        log.info(pizzaDTO.toString());
    }

    @Override
    public String getDescription() {
        return "I'm a Clay Oven";
    }

}
