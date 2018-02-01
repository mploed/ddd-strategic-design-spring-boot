package com.innoq.mploed.ddd.customer;

import com.innoq.mploed.ddd.customer.ws.Customer;
import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnablePrometheusEndpoint
public class CustomerWebServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerWebServiceApplication.class);
    }
}
