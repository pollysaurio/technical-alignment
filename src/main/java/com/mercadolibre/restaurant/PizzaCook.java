package com.mercadolibre.restaurant;

import com.mercadolibre.dto.PizzaDTO;
import com.mercadolibre.enums.OvenEnum;
import com.mercadolibre.patrones.factory.OvenFactory;
import com.mercadolibre.service.IOven;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PizzaCook {

    private final OvenFactory ovenFactory;

    public PizzaCook(OvenFactory ovenFactory) {
        this.ovenFactory = ovenFactory;
    }

    public void cook(OvenEnum ovenEnum, PizzaDTO pizzaDTO) {
        log.info("Start cooking... ");
        IOven iOven = ovenFactory.getOvenInstance(ovenEnum);
        iOven.cook(pizzaDTO);
        log.info("Finish cooking");
    }

}
