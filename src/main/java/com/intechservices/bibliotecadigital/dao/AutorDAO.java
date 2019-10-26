package com.intechservices.bibliotecadigital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intechservices.bibliotecadigital.model.Autor;

public interface AutorDAO extends JpaRepository<Autor, Integer>{

}