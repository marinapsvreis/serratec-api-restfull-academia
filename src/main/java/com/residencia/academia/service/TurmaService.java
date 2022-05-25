package com.residencia.academia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.academia.dto.TurmaDTO;
import com.residencia.academia.entity.Atividade;
import com.residencia.academia.entity.Instrutor;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.repository.AtividadeRepository;
import com.residencia.academia.repository.InstrutorRepository;
import com.residencia.academia.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private InstrutorRepository instrutorRepository;
	
	@Autowired
	private AtividadeRepository atividadeRepository;
	
	public List<Turma> findAll(){
		return turmaRepository.findAll();
	}
	
	public Turma findById(Integer id) {
		return turmaRepository.findById(id).isPresent() ? turmaRepository.findById(id).get() : null;
	}
	
	public TurmaDTO findTurmaDTOById(Integer id) {
		return turmaRepository.findById(id).isPresent() ? converterTurmaParaDTO(turmaRepository.findById(id).get()) : null;
	}
	
	public Turma save(Turma turma) {
		return turmaRepository.save(turma);
	}
	
	public Turma saveDTO(TurmaDTO turmaDTO) {
		Turma turma = converterDTOParaTurma(turmaDTO);
		return turmaRepository.save(turma);
	}
	
	public Turma update(Turma turma) {
		return turmaRepository.save(turma);
	}
	
	public void delete(Integer id) {
		turmaRepository.deleteById(id);
	}
	
	public TurmaDTO converterTurmaParaDTO(Turma turma) {
		TurmaDTO turmaDTO = new TurmaDTO();
		turmaDTO.setIdTurma(turma.getIdTurma());
		turmaDTO.setHorarioTurma(turma.getHorarioTurma());
		turmaDTO.setDuracaoTurma(turma.getDuracaoTurma());
		turmaDTO.setDataInicio(turma.getDataInicio());
		turmaDTO.setDataFim(turma.getDataFim());
		turmaDTO.setIdInstrutor(turma.getInstrutor().getIdInstrutor());
		turmaDTO.setNomeInstrutor(turma.getInstrutor().getNomeInstrutor());
		turmaDTO.setIdAtividade(turma.getAtividade().getIdAtividade());
		turmaDTO.setNomeAtividade(turma.getAtividade().getNomeAtividade());
		
		return turmaDTO;
	}
	
	public Turma converterDTOParaTurma(TurmaDTO turmaDTO) {
		Turma turma = new Turma();
		turma.setIdTurma(turmaDTO.getIdTurma());
		turma.setHorarioTurma(turmaDTO.getHorarioTurma());
		turma.setDuracaoTurma(turmaDTO.getDuracaoTurma());
		turma.setDataInicio(turmaDTO.getDataInicio());
		turma.setDataFim(turmaDTO.getDataFim());
		Instrutor instrutor = instrutorRepository.findById(turmaDTO.getIdInstrutor()).get();
		turma.setInstrutor(instrutor);
		Atividade atividade = atividadeRepository.findById(turmaDTO.getIdAtividade()).get();
		turma.setAtividade(atividade);
		
		return turma;
	}
	
}
