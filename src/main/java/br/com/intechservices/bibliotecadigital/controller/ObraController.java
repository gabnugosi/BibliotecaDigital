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

import br.com.intechservices.bibliotecadigital.dao.ObraDAO;
import br.com.intechservices.bibliotecadigital.model.Obra;

@RestController
@RequestMapping("/obras")
public class ObraController {
	@Autowired
	private ObraDAO dao;

	@PostMapping
	public void insert(@RequestBody Obra obra) {
		dao.save(obra);
	}

	@GetMapping
	public List<Obra> findAll() {
		return dao.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Obra> findById(@PathVariable Integer id) {
		return dao.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Obra> update(@PathVariable("id") Integer id, @RequestBody Obra obra) {
		return dao.findById(id).map(record -> {
			record.setNome(obra.getNome());
			record.setDescricao(obra.getDescricao());
			record.setIdEditora(obra.getIdEditora());
			record.setAno(obra.getAno());
			record.setEdicao(obra.getEdicao());
			record.setTombo(obra.getTombo());
			record.setStatus(obra.getStatus());
			record.setCategoria(obra.getCategoria());
			Obra updated = dao.save(record);
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
