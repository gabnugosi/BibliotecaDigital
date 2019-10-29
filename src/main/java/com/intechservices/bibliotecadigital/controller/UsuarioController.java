package com.intechservices.bibliotecadigital.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intechservices.bibliotecadigital.model.Usuario;

@RestController
public class UsuarioController {
	/*@Autowired
	private UsuarioRepo ususarioRepo;
	
	 @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
	 public ResponseEntity<Usuario> GetById(@PathVariable(value = "id") long id)
	    {
	        Optional<Usuario> usuario = ususario.findById(id);
	        if(pessoa.isPresent())
	            return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }*/
}
