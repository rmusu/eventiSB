package com.corso.java.EventiSB.service;

import java.util.List;

import com.corso.java.EventiSB.model.Evento;

public interface EventoService {

	public List<Evento> getAll();

	public void aggiungi(Evento e);

	public void rimuovi(Long id);

	public List<Evento> eventiDP(int durata, int numPartecipanti);

	public List<Evento> eventiLQ(String luogo);
	
	public Evento getByName(String nome);

}
