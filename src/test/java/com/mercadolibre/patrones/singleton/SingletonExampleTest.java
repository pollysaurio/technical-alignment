package com.mercadolibre.patrones.singleton;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class SingletonExampleTest {

    @Test
    public void getInstanceTest() {
        SingletonExample.getInstance().sum(1, 2);
        SingletonExample instance = SingletonExample.getInstance();
        log.info("Result 1: " + instance.sum(1, 2));
        SingletonExample secondInstance = SingletonExample.getInstance();
        log.info("Result 2: " + instance.sum(1, 2));
        assertEquals(instance, secondInstance);
        assertEquals(instance, SingletonExample.getInstance());
    }

}
