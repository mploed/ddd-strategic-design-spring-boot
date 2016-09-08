package com.innoq.mploed.ddd.scoring;

import com.innoq.mploed.ddd.scoring.shared.ScoringService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiServiceExporter;

@SpringBootApplication
public class ScoringApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScoringApplication.class);
    }

    @Bean
    public RmiServiceExporter nameRmiService(ScoringService scoringService) {
        RmiServiceExporter serviceExporter = new RmiServiceExporter();
        serviceExporter.setServiceName("scoringService");
        serviceExporter.setService(scoringService);
        serviceExporter.setServiceInterface(ScoringService.class);
        serviceExporter.setRegistryPort(1199);
        return serviceExporter;
    }
}
