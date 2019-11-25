package br.com.intechservices.bibliotecadigital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.intechservices.bibliotecadigital.dao.ModeradorDAO;
import br.com.intechservices.bibliotecadigital.model.Moderador;

public class ModeradorController {
	@Autowired
	private ModeradorDAO dao;

	@PostMapping
	public void insert(@RequestBody Moderador moderador) {
		dao.save(moderador);
	}

	@GetMapping
	public List<Moderador> findAll() {
		return dao.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Moderador> findById(@PathVariable Integer id) {
		return dao.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Moderador> update(@PathVariable("id") Integer id, @RequestBody Moderador moderador) {
		return dao.findById(id).map(record -> {
			record.setIdUser(moderador.getIdUser());
			Moderador updated = dao.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		return dao.findById(id).map(record -> {
			dao.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	
	}
}
