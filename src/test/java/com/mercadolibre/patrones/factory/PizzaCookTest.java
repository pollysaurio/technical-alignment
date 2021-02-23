package com.mercadolibre.patrones.factory;

import com.mercadolibre.AppConfig;
import com.mercadolibre.dto.PizzaDTO;
import com.mercadolibre.enums.OvenEnum;
import com.mercadolibre.restaurant.PizzaCook;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Slf4j
public class PizzaCookTest {

    @Autowired
    PizzaCook pizzaCook;

    @Test
    public void cookingPizzaWithGasOven() {
        PizzaDTO pizzaDTO = new PizzaDTO("Peperoni");
        pizzaCook.cook(OvenEnum.GAS, pizzaDTO);
    }

    @Test
    public void cookingPizzaWithElectricOven() {
        PizzaDTO pizzaDTO = new PizzaDTO("Mozzarella");
        pizzaCook.cook(OvenEnum.ELECTRIC, pizzaDTO);
    }

    @Test
    public void cookingPizzaWithClayOven() {
        PizzaDTO pizzaDTO = new PizzaDTO("Neapolitan");
        pizzaCook.cook(OvenEnum.CLAY, pizzaDTO);
    }

}
