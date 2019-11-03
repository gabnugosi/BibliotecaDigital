package br.com.intechservices.bibliotecadigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.intechservices.bibliotecadigital.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

}
