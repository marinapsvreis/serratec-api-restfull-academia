package com.residencia.academia.dto;

import java.util.List;

public class AtividadeDTO {

	private Integer idAtividade;
	private String nomeAtividade;
	private List<Integer> listaIdTurmasDTO;

	public Integer getIdAtividade() {
		return idAtividade;
	}

	public void setIdAtividade(Integer idAtividade) {
		this.idAtividade = idAtividade;
	}

	public String getNomeAtividade() {
		return nomeAtividade;
	}

	public void setNomeAtividade(String nomeAtividade) {
		this.nomeAtividade = nomeAtividade;
	}

	public List<Integer> getListaIdTurmasDTO() {
		return listaIdTurmasDTO;
	}

	public void setListaIdTurmasDTO(List<Integer> listaIdTurmasDTO) {
		this.listaIdTurmasDTO = listaIdTurmasDTO;
	}

}
