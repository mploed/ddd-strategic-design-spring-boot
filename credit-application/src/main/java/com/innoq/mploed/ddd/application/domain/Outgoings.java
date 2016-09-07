package com.innoq.mploed.ddd.application.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Outgoings {
    private long rent;
    private long loanRepayments;
    private long costOfLiving;

    public long sum() {
        return rent + loanRepayments + costOfLiving;
    }

    public long getRent() {
        return rent;
    }

    public void setRent(long rent) {
        this.rent = rent;
    }

    public long getLoanRepayments() {
        return loanRepayments;
    }

    public void setLoanRepayments(long loanRepayments) {
        this.loanRepayments = loanRepayments;
    }

    public long getCostOfLiving() {
        return costOfLiving;
    }

    public void setCostOfLiving(long costOfLiving) {
        this.costOfLiving = costOfLiving;
    }

    @Override
    public String toString() {
        return "Outgoings{" +
                "rent=" + rent +
                ", loanRepayments=" + loanRepayments +
                ", costOfLiving=" + costOfLiving +
                '}';
    }
}
