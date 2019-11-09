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

import br.com.intechservices.bibliotecadigital.dao.EnderecoDAO;
import br.com.intechservices.bibliotecadigital.model.Endereco;

@RestController
@RequestMapping("/enderecos")
public class EndercoController {
	@Autowired
	private EnderecoDAO dao;

	@PostMapping
	public void insert(@RequestBody Endereco endereco) {
		dao.save(endereco);
	}
	@GetMapping
	public List<Endereco> findAll(){
		return dao.findAll();
	}
	@GetMapping(path = {"/{id}"}) 
	public ResponseEntity<Endereco> findById(@PathVariable Integer id){
		return dao.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	@PutMapping(value="/{id}")
	public ResponseEntity<Endereco> update(@PathVariable("id") Integer id, @RequestBody Endereco endereco){
		return dao.findById(id)
				.map(record -> {
					record.setBairro(endereco.getBairro());
					record.setCep(endereco.getCep());
					record.setCidade(endereco.getCidade());
					record.setEstado(endereco.getEstado());
					record.setLogradouro(endereco.getLogradouro());
					record.setNomeLogradouro(endereco.getNomeLogradouro());
					record.setNumeroLogradouro(endereco.getNumeroLogradouro());
					Endereco updated = dao.save(record);
					return ResponseEntity.ok().body(updated);
				}).orElse(ResponseEntity.notFound().build());
	}
	@DeleteMapping(path= {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		return dao.findById(id)
				.map(record -> {
					dao.deleteById(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
				}
}
	