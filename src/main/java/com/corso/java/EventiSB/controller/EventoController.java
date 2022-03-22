package com.corso.java.EventiSB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.corso.java.EventiSB.model.Evento;
import com.corso.java.EventiSB.service.EventoService;

@RestController
public class EventoController {

	@Autowired
	EventoService es;

	@GetMapping("/listaEventi")
	public List<Evento> getAllEventi() {

		return es.getAll();
	}

	@PostMapping("/aggiungiEvento")
	public void aggiungi(@RequestBody Evento e) {

		es.aggiungi(e);
	}

	@DeleteMapping("/eliminaEvento/{id}")
	public void rimuovi(@PathVariable Long id) {

		es.rimuovi(id);
	}

	@GetMapping("/eventiDurataNumeroP/{durata}/{numPartecipanti}")
	public List<Evento> eventiDP(@PathVariable int durata, @PathVariable int numPartecipanti) {

		return es.eventiDP(durata, numPartecipanti);
	}

	@GetMapping("/eventiLuogoQuota/{luogo}")
	public List<Evento> eventiLQ(@PathVariable String luogo) {
		return es.eventiLQ(luogo);

	}

}
