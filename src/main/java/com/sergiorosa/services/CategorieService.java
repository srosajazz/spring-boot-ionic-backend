package com.sergiorosa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.sergiorosa.domain.Categorie;
import com.sergiorosa.repositories.CategoryRepository;
import com.sergiorosa.services.exceptions.ObjectNotFoundException;

@Service
public class CategorieService {

	@Autowired
	private CategoryRepository repo;

	public Categorie find(Integer id) {
		Optional<Categorie> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Categorie.class.getName()));

	}

	public Categorie insert(Categorie obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categorie update(Categorie obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Not possible to excluid a Category with produts");
			
		}
	}
	
	public List<Categorie> findAll(){
		return repo.findAll();
	}
	
	
}