package com.innoq.mploed.ddd.customercontact.receiver;

import com.innoq.mploed.ddd.customercontact.domain.Address;
import com.innoq.mploed.ddd.customercontact.events.CreditApplicationApprovedEvent;
import com.innoq.mploed.ddd.customercontact.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class  CreditApplicationApprovedEventReceiver {
    private AddressRepository addressRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(CreditApplicationApprovedEventReceiver.class);

    @Autowired
    public CreditApplicationApprovedEventReceiver(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void receiveMessage(CreditApplicationApprovedEvent creditApplicationApprovedEvent) {
        LOGGER.info("Received a CreditApplicationApprovedEvent for further processing: " + creditApplicationApprovedEvent.toString());
        Address address = addressRepository.findByCustomerId(creditApplicationApprovedEvent.getCustomerId());
        LOGGER.info("Sending a new credit contract to the following Address: " + address);
    }
}
