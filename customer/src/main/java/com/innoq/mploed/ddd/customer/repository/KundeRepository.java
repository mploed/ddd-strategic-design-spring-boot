package com.innoq.mploed.ddd.customer.repository;

import com.innoq.mploed.ddd.customer.domain.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KundeRepository extends JpaRepository<Kunde, Long> {
}
