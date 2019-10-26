package com.intechservices.bibliotecadigital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intechservices.bibliotecadigital.model.Obra;


public interface ObraDAO extends JpaRepository<Obra, Integer>{

}