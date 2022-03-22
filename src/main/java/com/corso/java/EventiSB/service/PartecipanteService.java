package com.corso.java.EventiSB.service;

import java.util.List;


import com.corso.java.EventiSB.model.Partecipante;

public interface PartecipanteService {
	

	public List<Partecipante> getAll();

	public void aggiungi(Partecipante p);

	public void rimuovi(Long id);
	
	public Partecipante getByNameSurname(String nome, String cognome);
	
	public int calcolaMP(String metodo);

	public int contaImportiMancanti();

}
