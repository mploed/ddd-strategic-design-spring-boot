package com.innoq.mploed.ddd.customercontact.repository;

import com.innoq.mploed.ddd.customercontact.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByCustomerId(String customerId);
}
