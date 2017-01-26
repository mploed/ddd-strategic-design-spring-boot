package com.innoq.mploed.ddd.customercontact.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

/**
 * Please note that this view on the actual CreditApplicationDeclinedEvent which is sent from credit-applicaiton
 * is not the whole event, we are only using amount and the customerId here.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditApplicationDeclinedEvent {

    private BigDecimal amount;

    String customerId;

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        return "CreditApplicationDeclinedEvent{" +
                "amount=" + amount +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
