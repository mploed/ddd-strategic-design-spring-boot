package com.innoq.mploed.ddd.customercontact;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnablePrometheusEndpoint
public class CustomerContactSpringBootApplication {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(CustomerContactSpringBootApplication.class, args);
    }
}
