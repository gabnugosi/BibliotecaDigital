package br.com.intechservices.bibliotecadigital.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.intechservices.bibliotecadigital.model.Reserva;

@RestController
@RequestMapping("reservas")
public class ReservaController {
	/*
	@RequestMapping("/reserva")
	public Reserva reserva(@RequestParam(value="name",defaultValue="Teste")String name) {
		return new reserva(String.format("Olá, %s", name));
	}*/
}
