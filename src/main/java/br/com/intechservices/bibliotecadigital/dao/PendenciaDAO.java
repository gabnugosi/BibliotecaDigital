package br.com.intechservices.bibliotecadigital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.intechservices.bibliotecadigital.model.Pendencia;

public interface PendenciaDAO extends JpaRepository<Pendencia, Integer>{

}