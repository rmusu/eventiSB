package com.corso.java.EventiSB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corso.java.EventiSB.model.Partecipante;

import com.corso.java.EventiSB.repositories.PartecipanteRepository;

@Service
public class PartecipanteServiceImpl implements PartecipanteService {

	@Autowired
	PartecipanteRepository pr;

	public List<Partecipante> getAll() {

		return pr.findAll();
	}

	public void aggiungi(Partecipante p) {

		pr.save(p);

	}

	public void rimuovi(Long id) {

		pr.deleteById(id);

	}

	public Partecipante getByNameSurname(String nome, String cognome) {

		return pr.getByNameSurname(nome, cognome);

	}

	public int calcolaMP(String metodo) {
		
		return pr.calcolaMP(metodo);
	}

	

	public int contaImportiMancanti() {
		
		return pr.contaImportiMancanti();
	}

}
