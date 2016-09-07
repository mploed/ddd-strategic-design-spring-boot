package com.innoq.mploed.ddd.application.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class CreditApplicaitonForm {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private int term;

    private BigDecimal amount;

    private BigDecimal percentage;

    private BigDecimal monthlyPayment;

    private String purpose;

    @Embedded
    private SelfDisclosure selfDisclosure;

    private Long customerId;
}
