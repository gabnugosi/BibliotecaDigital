package br.com.intechservices.bibliotecadigital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.intechservices.bibliotecadigital.model.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer>{

}