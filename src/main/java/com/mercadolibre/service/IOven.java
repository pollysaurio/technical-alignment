package com.mercadolibre.service;

import com.mercadolibre.dto.PizzaDTO;

public interface IOven {

    void cook(PizzaDTO pizzaDTO);
    String getDescription();

}
