package br.com.intechservices.bibliotecadigital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.intechservices.bibliotecadigital.model.ItemEmprestimo;

public interface ItemEmprestimoDAO extends JpaRepository<ItemEmprestimo, Integer>{

}