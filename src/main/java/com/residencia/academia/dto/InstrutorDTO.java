package com.residencia.academia.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InstrutorDTO {
	private Integer idInstrutor;
	private Integer rgInstrutor;
	private String nomeInstrutor;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataNascimentoInstrutor;
	private Integer titulacaoInstrutor;

	private List<Integer> listaIdTurmasDTO;

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

	public List<Integer> getListaIdTurmasDTO() {
		return listaIdTurmasDTO;
	}

	public void setListaIdTurmasDTO(List<Integer> listaIdTurmasDTO) {
		this.listaIdTurmasDTO = listaIdTurmasDTO;
	}

}
