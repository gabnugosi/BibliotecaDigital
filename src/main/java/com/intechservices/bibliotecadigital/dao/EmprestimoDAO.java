package com.intechservices.bibliotecadigital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intechservices.bibliotecadigital.model.Emprestimo;

public interface EmprestimoDAO extends JpaRepository<Emprestimo, Integer>{

}