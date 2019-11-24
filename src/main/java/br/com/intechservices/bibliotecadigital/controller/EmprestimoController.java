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

import br.com.intechservices.bibliotecadigital.dao.EmprestimoDAO;
import br.com.intechservices.bibliotecadigital.model.Emprestimo;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
	@Autowired
	private EmprestimoDAO dao;

	@PostMapping
	public void insert(@RequestBody Emprestimo emprestimo) {
		dao.save(emprestimo);
	}
	@GetMapping
	public List<Emprestimo> findAll(){
		return dao.findAll();
	}
	@GetMapping(path = {"/{id}"}) 
	public ResponseEntity<Emprestimo> findById(@PathVariable Integer id){
		return dao.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	@PutMapping(value="/{id}")
	public ResponseEntity<Emprestimo> update(@PathVariable("id") Integer id, @RequestBody Emprestimo emprestimo){
		return dao.findById(id)
				.map(record -> {
					record.setDtEmprestimoConcluido(emprestimo.getDtEmprestimoConcluido());
					record.setDtHoraDevolucao(emprestimo.getDtHoraDevolucao());
					record.setDtHoraEmp(emprestimo.getDtHoraEmp());
					record.setDtReserva(emprestimo.getDtReserva());
					record.setIdUser(emprestimo.getIdUser());
					record.setIdItemEmprestimo(emprestimo.getIdItemEmprestimo());
					Emprestimo updated = dao.save(record);
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
