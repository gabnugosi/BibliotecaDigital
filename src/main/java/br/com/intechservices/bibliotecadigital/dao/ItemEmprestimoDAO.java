package br.com.intechservices.bibliotecadigital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.intechservices.bibliotecadigital.model.itemEmprestimo;

public interface ItemEmprestimoDAO extends JpaRepository<itemEmprestimo, Integer>{

}