package com.innoq.mploed.ddd.application.controller;

import com.innoq.mploed.ddd.application.domain.CreditApplicationForm;
import com.innoq.mploed.ddd.application.domain.Customer;

public class ProcessContainer {
    private Customer customer;
    private CreditApplicationForm creditApplicationForm;

    public ProcessContainer() {
        this.customer = new Customer();
        this.creditApplicationForm = new CreditApplicationForm();
    }

    public CreditApplicationForm getCreditApplicationForm() {
        return creditApplicationForm;
    }

    public void setCreditApplicationForm(CreditApplicationForm creditApplicationForm) {
        this.creditApplicationForm = creditApplicationForm;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
