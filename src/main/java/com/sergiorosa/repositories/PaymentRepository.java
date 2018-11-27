package com.sergiorosa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sergiorosa.domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	

}
