package br.com.intechservices.bibliotecadigital.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.intechservices.bibliotecadigital.model.Usuario;
import br.com.intechservices.bibliotecadigital.repository.UsuarioRepository;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	 //@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	 public ResponseEntity<Usuario> GetById(@PathVariable(value = "id") long id)
	    {
	        Optional<Usuario> usuario = usuarioRepo.findById(id);
	        if(usuario.isPresent())
	            return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
		
		//@RequestMapping(method =  RequestMethod.POST)
		@PostMapping
	    public Usuario Post(@Valid @RequestBody Usuario usuario)
	    {
	        return usuarioRepo.save(usuario);
	    }
	 
		
		//@RequestMapping(method =  RequestMethod.PUT)
	    @PutMapping
		public ResponseEntity<Usuario> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Usuario newUsuario)
	    {
	        Optional<Usuario> oldUsuario = usuarioRepo.findById(id);
	        if(oldUsuario.isPresent()){
	            Usuario usuario = oldUsuario.get();
	            usuario.setNomeUsuario(newUsuario.getNomeUsuario());
	            usuarioRepo.save(usuario);
	            return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    
	    
	    //@RequestMapping(method = RequestMethod.DELETE)
	    @DeleteMapping
	    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
	    {
	        Optional<Usuario> usuario = usuarioRepo.findById(id);
	        if(usuario.isPresent()){
	            usuarioRepo.delete(usuario.get());
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	 
}