package br.com.intechservices.bibliotecadigital.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.intechservices.bibliotecadigital.model.Autor;
import br.com.intechservices.bibliotecadigital.repository.AutorRepository;


@RestController
@RequestMapping("/autores")
public class AutorController {
	@Autowired
	private AutorRepository autorRepo;
	
	 //@RequestMapping(method = RequestMethod.GET)
	
	 /*public ResponseEntity<Autor> GetById(@PathVariable(value = "id") int id)
	    {
	        Optional<Autor> autor = autorRepo.findById(id);
	        if(autor.isPresent())
	            return new ResponseEntity<Autor>(autor.get(), HttpStatus.OK);
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }*/
	@GetMapping
	 public String listaAutores(@RequestParam("id") int  id, Model model) {
		 model.addAttribute("id", id);
	        return "listaAutores";
	}
		//@RequestMapping(method =  RequestMethod.POST)
		@PostMapping
	    public Autor Post(@Valid @RequestBody Autor autor)
	    {
	        return autorRepo.save(autor);
	    }
	 
		
		//@RequestMapping(method =  RequestMethod.PUT)
	    @PutMapping
		public ResponseEntity<Autor> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Autor newAutor)
	    {
	        Optional<Autor> oldAutor = autorRepo.findById(id);
	        if(oldAutor.isPresent()){
	            Autor autor = oldAutor.get();
	            autor.setNome(newAutor.getNome());
	            autorRepo.save(autor);
	            return new ResponseEntity<Autor>(autor, HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    
	    
	    //@RequestMapping(method = RequestMethod.DELETE)
	    @DeleteMapping
	    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
	    {
	        Optional<Autor> autor = autorRepo.findById(id);
	        if(autor.isPresent()){
	            autorRepo.delete(autor.get());
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	 
}
