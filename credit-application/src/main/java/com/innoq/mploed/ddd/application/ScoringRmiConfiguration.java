package com.innoq.mploed.ddd.application;

import com.innoq.mploed.ddd.scoring.shared.ScoringService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@Configuration
public class ScoringRmiConfiguration {
    @Bean
    public RmiProxyFactoryBean scoringService() {
        RmiProxyFactoryBean nameServiceClient = new RmiProxyFactoryBean();
        nameServiceClient.setServiceUrl("rmi://localhost:1199/scoringService");
        nameServiceClient.setServiceInterface(ScoringService.class);
        return nameServiceClient;
    }
}
