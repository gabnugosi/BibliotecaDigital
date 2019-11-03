package br.com.intechservices.bibliotecadigital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.intechservices.bibliotecadigital.model.UsuarioSenha;

public interface UsuarioSenhaDAO extends JpaRepository<UsuarioSenha, Integer>{

}