package com.sergiorosa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sergiorosa.domain.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
	

}
