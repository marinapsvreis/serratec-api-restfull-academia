package com.residencia.academia.dto;

import java.util.List;

public class AtividadeDTO {

	private Integer idAtividade;
	private String nomeAtividade;
	private List<TurmaDTO> listaTurmasDTO;

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

	public List<TurmaDTO> getListaTurmasDTO() {
		return listaTurmasDTO;
	}

	public void setListaTurmasDTO(List<TurmaDTO> listaTurmasDTO) {
		this.listaTurmasDTO = listaTurmasDTO;
	}

	@Override
	public String toString() {
		return "AtividadeDTO [idAtividade=" + idAtividade + ", nomeAtividade=" + nomeAtividade + ", listaTurmasDTO="
				+ listaTurmasDTO + "]";
	}

}
