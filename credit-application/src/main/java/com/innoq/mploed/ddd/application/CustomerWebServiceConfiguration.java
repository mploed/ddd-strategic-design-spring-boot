package com.innoq.mploed.ddd.application;

import com.innoq.mploed.ddd.application.integration.customer.CustomerClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CustomerWebServiceConfiguration {
    @Value("${customerServer}")
    private String customerServer;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.innoq.mploed.ddd.application.integration.customer.wsdl");
        return marshaller;
    }


    @Bean
    public CustomerClient customerClient(Jaxb2Marshaller marshaller) {
        CustomerClient client = new CustomerClient(customerServer);
        client.setDefaultUri(customerServer + "ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
