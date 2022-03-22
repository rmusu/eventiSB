package com.corso.java.EventiSB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.corso.java.EventiSB.model.Partecipante;

@Repository
public interface PartecipanteRepository extends JpaRepository<Partecipante, Long> {

	// cerca partecipante per nome e cognome
	@Query(nativeQuery = true, value = "SELECT * FROM partecipanti WHERE nome=? AND cognome=?")
	Partecipante getByNameSurname(String nome, String cognome);

	// calcolo dei partecipanti che hanno scelto un certo metodo di pagamento
	@Query(nativeQuery = true, value = "SELECT COUNT(*) FROM partecipanti WHERE metodo_pagamento = ?")
	int calcolaMP(String metodo);

	// numero partecipanti che non hanno versato per intero la quota di iscrizione
	@Query(nativeQuery = true, value = "SELECT count(*) as conta FROM partecipanti as p join eventi as e on p.id_evento = "
			+ "e.id_evento WHERE p.importo_versato < e.quota_iscrizione")
	int contaImportiMancanti();

}
