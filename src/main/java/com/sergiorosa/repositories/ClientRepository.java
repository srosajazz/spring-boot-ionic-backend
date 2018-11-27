package com.sergiorosa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sergiorosa.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	

}
