package com.innoq.mploed.ddd.customer.webservice;

import com.innoq.mploed.ddd.customer.domain.Kunde;
import com.innoq.mploed.ddd.customer.domainevents.CustomerCreatedEvent;
import com.innoq.mploed.ddd.customer.repository.KundeRepository;
import com.innoq.mploed.ddd.customer.ws.Customer;
import com.innoq.mploed.ddd.customer.ws.SaveCustomerRequest;
import com.innoq.mploed.ddd.customer.ws.SaveCustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CustomerEndpoint {
    private static final String NAMESPACE_URI = "http://innoq.com/mploed/ddd/customer/ws";

    private KundeRepository kundeRepository;

    private RedisTemplate redisTemplate;

    @Autowired
    public CustomerEndpoint(KundeRepository kundeRepository, RedisTemplate redisTemplate) {
        this.kundeRepository = kundeRepository;
        this.redisTemplate = redisTemplate;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveCustomerRequest")
    @ResponsePayload
    public SaveCustomerResponse saveCustoemr(@RequestPayload SaveCustomerRequest request) {
        SaveCustomerResponse response = new SaveCustomerResponse();
        Customer customer = request.getCustomer();
        Kunde kunde = new Kunde();
        kunde.setNachname(customer.getLastName());
        kunde.setVorname(customer.getFirstName());
        kunde.setStrasse(customer.getStreet());
        kunde.setPlz(customer.getPostCode());
        kunde.setStadt(customer.getCity());
        Kunde savedKunde = kundeRepository.saveAndFlush(kunde);
        redisTemplate.convertAndSend("customer-created-events", new CustomerCreatedEvent(savedKunde));
        customer.setId(savedKunde.getId());
        response.setCustomer(customer);

        return response;
    }
}
