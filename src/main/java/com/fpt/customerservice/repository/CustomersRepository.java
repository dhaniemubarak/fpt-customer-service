package com.fpt.customerservice.repository;

import com.fpt.customerservice.domain.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {
}
