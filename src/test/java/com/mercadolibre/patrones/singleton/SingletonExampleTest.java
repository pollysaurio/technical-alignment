package com.mercadolibre.patrones.singleton;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SingletonExampleTest {

    @Test
    public void getInstanceTest() {
        SingletonExample.getInstance().sum(1, 2);
        SingletonExample instance = SingletonExample.getInstance();
        instance.sum(1, 2);
        SingletonExample secondInstance = SingletonExample.getInstance();
        secondInstance.sum(1, 2);
        assertEquals(instance, secondInstance);
        assertEquals(instance, SingletonExample.getInstance());
    }

}
