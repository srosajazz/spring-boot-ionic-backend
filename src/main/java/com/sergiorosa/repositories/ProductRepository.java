package com.sergiorosa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sergiorosa.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	

}
