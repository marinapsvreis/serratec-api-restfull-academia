package com.residencia.academia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.academia.dto.AtividadeDTO;
import com.residencia.academia.dto.InstrutorDTO;
import com.residencia.academia.dto.TurmaDTO;
import com.residencia.academia.entity.Atividade;
import com.residencia.academia.entity.Instrutor;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.repository.AtividadeRepository;

@Service
public class AtividadeService {
	
		@Autowired
		private AtividadeRepository atividadeRepository;
		
		@Autowired
		private TurmaService turmaService;
		
		public List<Atividade> findAll(){
			return atividadeRepository.findAll();
		}
		
		public Atividade findById(Integer id) {
			return atividadeRepository.findById(id).isPresent() ? atividadeRepository.findById(id).get() : null;
		}
		
		public AtividadeDTO findAtividadeDTOById(Integer id) {
			return atividadeRepository.findById(id).isPresent() ? converterAtividadeParaDTO(atividadeRepository.findById(id).get()) : null;
		}
		
		public Atividade save(Atividade atividade) {
			return atividadeRepository.save(atividade);
		}
		
		public Atividade saveDTO(AtividadeDTO atividadeDTO) {
			Atividade atividade = converterDTOParaAtividade(atividadeDTO);
			return atividadeRepository.save(atividade);
		}
		
		public Atividade update(Atividade atividade) {
			return atividadeRepository.save(atividade);

		}
		
		public void delete(Integer id) {
			Atividade atividade = atividadeRepository.findById(id).get();
	        atividadeRepository.delete(atividade);
		}
		
		private AtividadeDTO converterAtividadeParaDTO(Atividade atividade) {
			AtividadeDTO atividadeDTO = new AtividadeDTO();
			atividadeDTO.setIdAtividade(atividade.getIdAtividade());
			atividadeDTO.setNomeAtividade(atividade.getNomeAtividade());
			
			List<TurmaDTO> listaTurmaDTO = new ArrayList<>();
			
			for(Turma turma : atividade.getListaTurmas()) {
				TurmaDTO turmaDTO = turmaService.converterTurmaParaDTO(turma);
				listaTurmaDTO.add(turmaDTO);
			}
			
			atividadeDTO.setListaTurmasDTO(listaTurmaDTO);
			
			return atividadeDTO;
		}
		
		private Atividade converterDTOParaAtividade(AtividadeDTO atividadeDTO) {
			Atividade atividade = new Atividade();
			atividade.setIdAtividade(atividadeDTO.getIdAtividade());
			atividade.setNomeAtividade(atividadeDTO.getNomeAtividade());

			return atividade;
		}
		
}
