package com.residencia.academia.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.residencia.academia.entity.Atividade;
import com.residencia.academia.entity.Instrutor;

public class TurmaDTO {

	private Integer idTurma;
	@JsonFormat(pattern = "HH:mm:ss")
	private Date horarioTurma;
	private Integer duracaoTurma;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataInicio;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataFim;

	private Integer idInstrutor;
	private String nomeInstrutor;
	private Integer idAtividade;
	private String nomeAtividade;

	public Integer getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Integer idTurma) {
		this.idTurma = idTurma;
	}

	public Date getHorarioTurma() {
		return horarioTurma;
	}

	public void setHorarioTurma(Date horarioTurma) {
		this.horarioTurma = horarioTurma;
	}

	public Integer getDuracaoTurma() {
		return duracaoTurma;
	}

	public void setDuracaoTurma(Integer duracaoTurma) {
		this.duracaoTurma = duracaoTurma;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Integer getIdInstrutor() {
		return idInstrutor;
	}

	public void setIdInstrutor(Integer idInstrutor) {
		this.idInstrutor = idInstrutor;
	}

	public Integer getIdAtividade() {
		return idAtividade;
	}

	public void setIdAtividade(Integer idAtividade) {
		this.idAtividade = idAtividade;
	}

	public String getNomeInstrutor() {
		return nomeInstrutor;
	}

	public void setNomeInstrutor(String nomeInstrutor) {
		this.nomeInstrutor = nomeInstrutor;
	}

	public String getNomeAtividade() {
		return nomeAtividade;
	}

	public void setNomeAtividade(String nomeAtividade) {
		this.nomeAtividade = nomeAtividade;
	}

	@Override
	public String toString() {
		return "TurmaDTO [idTurma=" + idTurma + ", horarioTurma=" + horarioTurma + ", duracaoTurma=" + duracaoTurma
				+ ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", idInstrutor=" + idInstrutor
				+ ", idAtividade=" + idAtividade + "]";
	}

}
