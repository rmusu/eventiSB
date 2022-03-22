package com.corso.java.EventiSB.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.corso.java.EventiSB.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

	// cerca evento per nome
	@Query(nativeQuery = true, value = "SELECT * FROM evento WHERE nome=?")
	Evento getByName(String nome);

//	Elenco di tutti gli eventi aventi durata superiore ad un dato numero di giorni, e numero di partecipanti superiore ad un dato numero
	@Query(nativeQuery = true, value = "SELECT e.*, count(*) as conta FROM partecipanti as p join eventi as e on p.id_evento =\n"
			+ "e.id_evento WHERE e.durata > ? group by e.id_evento  having conta > ?")
	List<Evento> eventiDP(int durata, int numPartecipanti);

//	Elenco di tutti gli eventi svolti in un dato luogo il cui costo totale non sia stato coperto dalle quote di iscrizione

	@Query(nativeQuery = true, value = "SELECT e.*, SUM(p.importo_versato) as somma, COUNT(*) as conta  FROM partecipanti as p join eventi as e on p.id_evento =e.id_evento WHERE e.luogo = ?1 "
			+ "group by e.id_evento  having somma <(e.quota_iscrizione*conta) ;")
	List<Evento> eventiLQ(String luogo);

}
