package com.corso.java.EventiSB.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;





@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "eventi")
public class Evento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_evento")
	private Long idEvento;
	@Column(name = "nome")
	private String nome;
	@Column(name = "luogo")
	private String luogo;
	@Column(name = "quota_Iscrizione")
	private Double quotaIscrizione;
	@Column(name = "durata")
	private int durata;
	
	public Evento(Long idEvento, String nome, String luogo, Double quotaIscrizione, int durata) {
		this.idEvento = idEvento;
		this.nome = nome;
		this.luogo = luogo;
		this.quotaIscrizione = quotaIscrizione;
		this.durata = durata;
	}
	
	public Evento() {
		
	}

	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public Double getQuotaIscrizione() {
		return quotaIscrizione;
	}

	public void setQuotaIscrizione(Double quotaIscrizione) {
		this.quotaIscrizione = quotaIscrizione;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}
		
	

}
