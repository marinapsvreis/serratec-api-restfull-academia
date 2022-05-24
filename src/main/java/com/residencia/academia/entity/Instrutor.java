package com.residencia.academia.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "instrutor")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idInstrutor")
public class Instrutor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_instrutor")
	private Integer idInstrutor;

	@Column(name = "rg")
	private Integer rgInstrutor;

	@Column(name = "nome")
	private String nomeInstrutor;

	@Column(name = "nascimento")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataNascimentoInstrutor;

	@Column(name = "titulacao")
	private Integer titulacaoInstrutor;
	
	@OneToMany(mappedBy="instrutor")
	//@JsonIgnore
	//@JsonBackReference
	private List<Turma> listaTurmas; 

	public Integer getIdInstrutor() {
		return idInstrutor;
	}

	public void setIdInstrutor(Integer idInstrutor) {
		this.idInstrutor = idInstrutor;
	}

	public Integer getRgInstrutor() {
		return rgInstrutor;
	}

	public void setRgInstrutor(Integer rgInstrutor) {
		this.rgInstrutor = rgInstrutor;
	}

	public String getNomeInstrutor() {
		return nomeInstrutor;
	}

	public void setNomeInstrutor(String nomeInstrutor) {
		this.nomeInstrutor = nomeInstrutor;
	}

	public Date getDataNascimentoInstrutor() {
		return dataNascimentoInstrutor;
	}

	public void setDataNascimentoInstrutor(Date dataNascimentoInstrutor) {
		this.dataNascimentoInstrutor = dataNascimentoInstrutor;
	}

	public Integer getTitulacaoInstrutor() {
		return titulacaoInstrutor;
	}

	public void setTitulacaoInstrutor(Integer titulacaoInstrutor) {
		this.titulacaoInstrutor = titulacaoInstrutor;
	}

	public List<Turma> getListaTurmas() {
		return listaTurmas;
	}

	public void setListaTurmas(List<Turma> listaTurmas) {
		this.listaTurmas = listaTurmas;
	}
	
}
