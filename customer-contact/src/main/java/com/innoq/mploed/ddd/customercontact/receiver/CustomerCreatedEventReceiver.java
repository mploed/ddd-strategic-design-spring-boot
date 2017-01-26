package com.innoq.mploed.ddd.customercontact.receiver;

import com.innoq.mploed.ddd.customercontact.domain.Address;
import com.innoq.mploed.ddd.customercontact.events.CustomerCreatedEvent;
import com.innoq.mploed.ddd.customercontact.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerCreatedEventReceiver {

    private AddressRepository addressRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerCreatedEventReceiver.class);

    @Autowired
    public CustomerCreatedEventReceiver(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void receiveMessage(CustomerCreatedEvent customerCreatedEvent) {
        LOGGER.info("Received a CustomerCreatedEvent for further processing: " + customerCreatedEvent.toString());
        Address addressFromEvent = customerCreatedEvent.toAddress();
        LOGGER.info("Converted the CustomerCreatedEvent to an Address: " + addressFromEvent);
        Address savedAddress = addressRepository.save(addressFromEvent);
        LOGGER.info("Saved Address: " + savedAddress.toString());
    }
}
