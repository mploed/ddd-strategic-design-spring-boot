package com.innoq.mploed.ddd.application.events;

import com.innoq.mploed.ddd.application.domain.CreditApplicationForm;

import java.math.BigDecimal;

public class CreditApplicationApprovedEvent {

    private int term;

    private BigDecimal amount;

    private BigDecimal percentage;

    String customerId;

    String creditApplicationId;


    public CreditApplicationApprovedEvent(CreditApplicationForm creditApplicationForm) {
        this.term = creditApplicationForm.getTerm();
        this.amount = creditApplicationForm.getAmount();
        this.percentage = creditApplicationForm.getPercentage();
        this.customerId = creditApplicationForm.getCustomerId().toString();
        this.creditApplicationId = creditApplicationForm.getId().toString();
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
