package com.sergiorosa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sergiorosa.domain.Categorie;

@Repository
public interface CategoryRepository extends JpaRepository<Categorie, Integer> {
	

}
