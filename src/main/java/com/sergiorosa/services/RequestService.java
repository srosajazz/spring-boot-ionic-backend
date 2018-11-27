package com.sergiorosa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sergiorosa.domain.Request;
import com.sergiorosa.repositories.RequestRepository;
import com.sergiorosa.services.exceptions.ObjectNotFoundException;

@Service
public class RequestService {

	@Autowired
	private RequestRepository repo;

	public Request find(Integer id) {
		Optional<Request> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " 
						+ id 
						+ ", Type: " 
						+ Request.class.getName()));

	}
}