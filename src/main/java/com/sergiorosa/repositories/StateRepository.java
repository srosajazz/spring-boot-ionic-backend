package com.sergiorosa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sergiorosa.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
	

}
