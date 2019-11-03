package br.com.intechservices.bibliotecadigital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.intechservices.bibliotecadigital.model.UsuarioInadimplente;

public interface UsuarioInadimplenteDAO extends JpaRepository<UsuarioInadimplente, Integer>{

}