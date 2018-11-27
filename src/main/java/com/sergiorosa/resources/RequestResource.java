package com.sergiorosa.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sergiorosa.domain.Request;
import com.sergiorosa.services.RequestService;

@RestController
@RequestMapping(value="/request")
public class RequestResource {
	
	@Autowired
	private RequestService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?>find(@PathVariable Integer id) { 
		Request obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
		
		
	}

}
