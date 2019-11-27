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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.intechservices.bibliotecadigital.dao.AutorDAO;
import br.com.intechservices.bibliotecadigital.model.Autor;

@RestController
@RequestMapping("/autores")
public class AutorController {
	@Autowired
	private AutorDAO dao;

	@PostMapping
	public void insert(@RequestBody Autor autor) {
		dao.save(autor);
	}

	@GetMapping
	public List<Autor> findAll() {
		return dao.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Autor> findById(@PathVariable Integer id) {
		return dao.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Autor> update(@PathVariable("id") Integer id, @RequestBody Autor autor) {
		return dao.findById(id).map(record -> {
			record.setNome(autor.getNome());
			record.setFirstname(autor.getFirstname());
			record.setLastname(record.getLastname());
			Autor updated = dao.save(record);
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
