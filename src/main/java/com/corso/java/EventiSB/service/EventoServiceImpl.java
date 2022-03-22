package com.corso.java.EventiSB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corso.java.EventiSB.model.Evento;
import com.corso.java.EventiSB.repositories.EventoRepository;

@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	EventoRepository er;

	public List<Evento> getAll() {

		return er.findAll();
	}

	public void aggiungi(Evento e) {

		er.save(e);
	}

	public void rimuovi(Long id) {
		er.deleteById(id);

	}

	public List<Evento> eventiDP(int durata, int numPartecipanti) {

		return er.eventiDP(durata, numPartecipanti);
	}

	public List<Evento> eventiLQ(String luogo) {

		return er.eventiLQ(luogo);
	}
	
	public Evento getByName(String nome) {
		
		return er.getByName(nome);
	}

}
