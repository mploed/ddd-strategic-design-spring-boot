package com.innoq.mploed.ddd.application;

import com.innoq.mploed.ddd.scoring.shared.ScoringService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@Configuration
public class ScoringHessianConfiguration {
    @Bean
    public HessianProxyFactoryBean scoringService() {
        HessianProxyFactoryBean scoringServiceClient = new HessianProxyFactoryBean();
        scoringServiceClient.setServiceUrl("https://mploed-scoring.cfapps.io/remoting/ScoringService");
        scoringServiceClient.setServiceInterface(ScoringService.class);
        return scoringServiceClient;
    }
}
