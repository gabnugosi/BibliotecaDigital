package br.com.intechservices.bibliotecadigital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.intechservices.bibliotecadigital.dao.ReservaDAO;
import br.com.intechservices.bibliotecadigital.model.Reserva;

@RestController
@RequestMapping("reservas")
public class ReservaController {
	@Autowired
	private ReservaDAO dao;

	@PostMapping
	public void insert(@RequestBody Reserva reserva) {
		dao.save(reserva);
	}
	@GetMapping
	public List<Reserva> findAll(){
		return dao.findAll();
	}
	@GetMapping(path = {"/{id}"}) 
	public ResponseEntity<Reserva> findById(@PathVariable Integer id){
		return dao.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	/*
	@PutMapping(value="/{id}")
	public ResponseEntity<Reserva> update(@PathVariable("id") Integer id, @RequestBody Reserva reserva){
		return dao.findById(id)
				.map(record -> {
					record.setNome(obra.getNome());

					Reserva updated = dao.save(record);
					return ResponseEntity.ok().body(updated);
				}).orElse(ResponseEntity.notFound().build());
	}*/
	@DeleteMapping(path= {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		return dao.findById(id)
				.map(record -> {
					dao.deleteById(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
				}
}