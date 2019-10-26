package com.intechservices.bibliotecadigital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intechservices.bibliotecadigital.model.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer>{

}