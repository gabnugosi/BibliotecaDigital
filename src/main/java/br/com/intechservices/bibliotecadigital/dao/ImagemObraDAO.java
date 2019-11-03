package br.com.intechservices.bibliotecadigital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.intechservices.bibliotecadigital.model.ImagemObra;

public interface ImagemObraDAO extends JpaRepository<ImagemObra, Integer>{

}