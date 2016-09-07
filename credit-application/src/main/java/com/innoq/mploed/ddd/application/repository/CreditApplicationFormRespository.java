package com.innoq.mploed.ddd.application.repository;

import com.innoq.mploed.ddd.application.domain.CreditApplicationForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditApplicationFormRespository extends JpaRepository<CreditApplicationForm, Long> {
}
