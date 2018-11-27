package com.sergiorosa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sergiorosa.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	

}
