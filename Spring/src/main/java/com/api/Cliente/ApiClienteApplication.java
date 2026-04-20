package com.api.Cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients(basePackages = "com.api.Cliente")
@SpringBootApplication
public class ApiClienteApplication  {

    public static void main(String[] args) {
        SpringApplication.run(ApiClienteApplication.class, args);
    }
}
