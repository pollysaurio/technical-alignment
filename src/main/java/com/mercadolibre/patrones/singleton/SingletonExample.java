package com.mercadolibre.patrones.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingletonExample {

    /* Debemos evitar que la clase singleton tenga estado */
    /* Cuando hablamos de estado de un objeto nos referimos al valor de las variables del objeto en un momento dado */
    /* Por ejemplo */
    /* String List<String> valores; */
    /* Al declarar un objeto de esa manera le damos un estado al objeto, la variable valores puede cambiar su valor y modificar el comportamiento del objeto */

    // Declare a instance of the same class and init the instance with null
    private static SingletonExample instance = null;

    // Declare a private Constructor
    private SingletonExample() {
        log.info("I'm a Singleton :D ");
    }

    // Declare a public static method to construct/get the instance
    public static SingletonExample getInstance() {
        if(instance == null)
            instance = new SingletonExample();
        return instance;
    }

    public int sum(int num1, int num2) {
        return num1 + num2;
    }

}
