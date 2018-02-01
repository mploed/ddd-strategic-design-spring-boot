package com.innoq.mploed.ddd.scoring;

import com.innoq.mploed.ddd.scoring.shared.ScoringService;
import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnablePrometheusEndpoint
public class ScoringApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScoringApplication.class);
    }

    @Bean(name = "/ScoringService")
    public HessianServiceExporter scoringHessianService(ScoringService scoringService) {
        HessianServiceExporter hessianServiceExporter = new HessianServiceExporter();
        hessianServiceExporter.setService(scoringService);
        hessianServiceExporter.setServiceInterface(ScoringService.class);
        return hessianServiceExporter;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
