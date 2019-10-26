package com.intechservices.bibliotecadigital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intechservices.bibliotecadigital.model.UsuarioSenha;

public interface UsuarioSenhaDAO extends JpaRepository<UsuarioSenha, Integer>{

}