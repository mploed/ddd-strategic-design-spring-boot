package com.innoq.mploed.ddd.customercontact.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

@Component
public class SendContractMessageReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(SendContractMessageReceiver.class);

    public void receiveMessage (String message) {
        LOGGER.info(message);
    }
    public void receiveMessage(CreditApplicationApprovedEvent creditApplicationApprovedEvent) {
        LOGGER.info(creditApplicationApprovedEvent.toString());
    }
}
