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

import br.com.intechservices.bibliotecadigital.dao.ImagemObraDAO;
import br.com.intechservices.bibliotecadigital.model.ImagemObra;


@RestController
@RequestMapping("/imagemobras")
public class ImagemObraController {
	@Autowired
	private ImagemObraDAO dao;

	@PostMapping
	public void insert(@RequestBody ImagemObra imgObra) {
		dao.save(imgObra);
	}
	@GetMapping
	public List<ImagemObra> findAll(){
		return dao.findAll();
	}
	@GetMapping(path = {"/{id}"}) 
	public ResponseEntity<ImagemObra> findById(@PathVariable Integer id){
		return dao.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	//incluir a relação com a tabela
	@PutMapping(value="/{id}")
	public ResponseEntity<ImagemObra> update(@PathVariable("id") Integer id, @RequestBody ImagemObra imgObra){
		return dao.findById(id)
				.map(record -> {					
					record.setIdObra(imgObra.getIdObra());
					record.setUrlimg(imgObra.getUrlimg());
					ImagemObra updated = dao.save(record);
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

