package com.innoq.mploed.ddd.customercontact.receiver;

import com.innoq.mploed.ddd.customercontact.domain.Address;
import com.innoq.mploed.ddd.customercontact.events.CreditApplicationApprovedEvent;
import com.innoq.mploed.ddd.customercontact.events.CreditApplicationDeclinedEvent;
import com.innoq.mploed.ddd.customercontact.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreditApplicationDeclinedEventReceiver {
    private AddressRepository addressRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(CreditApplicationDeclinedEventReceiver.class);

    @Autowired
    public CreditApplicationDeclinedEventReceiver(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void receiveMessage(CreditApplicationDeclinedEvent creditApplicationDeclinedEvent) {
        LOGGER.info("Received a CreditApplicationDeclinedEvent for further processing: " + creditApplicationDeclinedEvent.toString());
        Address address = addressRepository.findByCustomerId(creditApplicationDeclinedEvent.getCustomerId());
        LOGGER.info("Sending a new 'sorry letter' to the following Address: " + address);
    }
}
