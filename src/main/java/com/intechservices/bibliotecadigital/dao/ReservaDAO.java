package com.intechservices.bibliotecadigital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intechservices.bibliotecadigital.model.Reserva;

public interface ReservaDAO extends JpaRepository<Reserva, Integer>{

}