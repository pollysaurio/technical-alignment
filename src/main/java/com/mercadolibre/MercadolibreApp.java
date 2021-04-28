package com.mercadolibre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class MercadolibreApp {
    public static void main(String[] args) {
        SpringApplication.run(MercadolibreApp.class, args);
    }
}
