package com.innoq.mploed.ddd.creditAgency;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnablePrometheusEndpoint
public class CreditAgencyApplication {
    public static void main(String[] args) {
        SpringApplication.run(CreditAgencyApplication.class);
    }
}
