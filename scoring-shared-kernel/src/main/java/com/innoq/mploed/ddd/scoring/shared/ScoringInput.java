package com.innoq.mploed.ddd.scoring.shared;

import java.io.Serializable;

public class ScoringInput implements Serializable {
    String firstName;
    String lastName;
    String street;
    String postCode;

    long income;
    long spendings;

    long monthlyPayment;
    String reason;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public long getIncome() {
        return income;
    }

    public void setIncome(long income) {
        this.income = income;
    }

    public long getSpendings() {
        return spendings;
    }

    public void setSpendings(long spendings) {
        this.spendings = spendings;
    }

    public long getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(long monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
