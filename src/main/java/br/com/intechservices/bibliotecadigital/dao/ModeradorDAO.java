package br.com.intechservices.bibliotecadigital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.intechservices.bibliotecadigital.model.Moderador;

public interface ModeradorDAO extends JpaRepository<Moderador, Integer>{

}