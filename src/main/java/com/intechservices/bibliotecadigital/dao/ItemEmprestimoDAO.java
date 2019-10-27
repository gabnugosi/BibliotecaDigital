package com.intechservices.bibliotecadigital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intechservices.bibliotecadigital.model.itemEmprestimo;

public interface ItemEmprestimoDAO extends JpaRepository<itemEmprestimo, Integer>{

}