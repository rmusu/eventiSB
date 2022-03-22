package com.corso.java.EventiSB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.corso.java.EventiSB.model.Partecipante;

import com.corso.java.EventiSB.service.PartecipanteService;

@RestController
public class PartecipanteController {

	@Autowired
	PartecipanteService ps;

	@GetMapping("/listaPartecipanti")
	public List<Partecipante> getAllPartecipanti() {

		return ps.getAll();
	}

	@PostMapping("/aggiungiPartecipante")
	public void aggiungi(@RequestBody Partecipante p) {

		ps.aggiungi(p);
	}

	@DeleteMapping("/rimuoviPartecipante/{id}")
	public void rimuovi(@PathVariable Long id) {

		ps.rimuovi(id);
	}

	@GetMapping("/calcolaMetodo/{metodo}")
	public int calcolaMP(@PathVariable String metodo) {

		return ps.calcolaMP(metodo);
	}



	@GetMapping("/contaImportiMancanti")
	public int importiMancanti() {

		return ps.contaImportiMancanti();
	}

}
