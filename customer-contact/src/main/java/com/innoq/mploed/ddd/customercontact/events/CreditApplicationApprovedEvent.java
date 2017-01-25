package com.innoq.mploed.ddd.customercontact.events;

import java.math.BigDecimal;

public class CreditApplicationApprovedEvent {

    private int term;

    private BigDecimal amount;

    private BigDecimal percentage;

    String customerId;

    String creditApplicationId;


    public int getTerm() {
        return term;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCreditApplicationId() {
        return creditApplicationId;
    }

    @Override
    public String toString() {
        return "CreditApplicationApprovedEvent{" +
                "term=" + term +
                ", amount=" + amount +
                ", percentage=" + percentage +
                ", customerId='" + customerId + '\'' +
                ", creditApplicationId='" + creditApplicationId + '\'' +
                '}';
    }
}
