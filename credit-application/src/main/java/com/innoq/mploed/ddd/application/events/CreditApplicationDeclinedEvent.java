package com.innoq.mploed.ddd.application.events;

import com.innoq.mploed.ddd.application.domain.CreditApplicationForm;

import java.math.BigDecimal;

public class CreditApplicationDeclinedEvent {

    private int term;

    private BigDecimal amount;

    String customerId;

    String creditApplicationId;


    public CreditApplicationDeclinedEvent(CreditApplicationForm creditApplicationForm) {
        this.term = creditApplicationForm.getTerm();
        this.amount = creditApplicationForm.getAmount();
        this.customerId = creditApplicationForm.getCustomerId().toString();
        this.creditApplicationId = creditApplicationForm.getId().toString();
    }

    public int getTerm() {
        return term;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCreditApplicationId() {
        return creditApplicationId;
    }
}
