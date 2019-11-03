package br.com.intechservices.bibliotecadigital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.intechservices.bibliotecadigital.model.Endereco;

public interface EnderecoDAO extends JpaRepository<Endereco, Integer>{

}