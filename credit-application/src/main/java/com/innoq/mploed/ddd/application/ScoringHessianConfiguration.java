package com.innoq.mploed.ddd.application;

import com.innoq.mploed.ddd.scoring.shared.ScoringService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@Configuration
public class ScoringHessianConfiguration {
    @Value("${scoringServer}")
    private String scoringServer;

    @Bean
    public HessianProxyFactoryBean scoringService() {
        HessianProxyFactoryBean scoringServiceClient = new HessianProxyFactoryBean();
        scoringServiceClient.setServiceUrl(scoringServer + "ScoringService");
        scoringServiceClient.setServiceInterface(ScoringService.class);
        return scoringServiceClient;
    }
}
