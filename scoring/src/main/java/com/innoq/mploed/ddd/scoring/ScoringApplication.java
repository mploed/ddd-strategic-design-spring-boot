package com.innoq.mploed.ddd.scoring;

import com.innoq.mploed.ddd.scoring.shared.ScoringService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ScoringApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScoringApplication.class);
    }

    @Bean(name="/ScoringService")
    public HessianServiceExporter socringHessianService(ScoringService scoringService) {
        HessianServiceExporter serviceExporter = new HessianServiceExporter();
        serviceExporter.setService(scoringService);
        serviceExporter.setServiceInterface(ScoringService.class);

        return serviceExporter;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
