package com.innoq.mploed.ddd.application.domain;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class Earnings {
    long income;
    long childBenefit;
    long rentalIncome;

    public long sum() {
        return income + childBenefit + rentalIncome;
    }

    public long getIncome() {
        return income;
    }

    public void setIncome(long income) {
        this.income = income;
    }

    public long getChildBenefit() {
        return childBenefit;
    }

    public void setChildBenefit(long childBenefit) {
        this.childBenefit = childBenefit;
    }

    public long getRentalIncome() {
        return rentalIncome;
    }

    public void setRentalIncome(long rentalIncome) {
        this.rentalIncome = rentalIncome;
    }

    @Override
    public String toString() {
        return "Earnings{" +
                "income=" + income +
                ", childBenefit=" + childBenefit +
                ", rentalIncome=" + rentalIncome +
                '}';
    }
}
