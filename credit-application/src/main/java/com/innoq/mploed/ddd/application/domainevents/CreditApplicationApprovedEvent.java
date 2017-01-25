package com.innoq.mploed.ddd.application.domainevents;

import java.math.BigDecimal;

public class CreditApplicationApprovedEvent {

    private int term;

    private BigDecimal amount;

    private BigDecimal percentage;

    String customerId;

    String creditApplicationId;


    public CreditApplicationApprovedEvent(int term, BigDecimal amount, BigDecimal percentage, String customerId, String creditApplicationId) {
        this.term = term;
        this.amount = amount;
        this.percentage = percentage;
        this.customerId = customerId;
        this.creditApplicationId = creditApplicationId;
    }

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
}
