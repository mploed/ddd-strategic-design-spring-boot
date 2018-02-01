package com.innoq.mploed.ddd.application;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnablePrometheusEndpoint
public class BigPugLoansApplication {
    public static void main(String[] args) {
        SpringApplication.run(BigPugLoansApplication.class);
    }
}
