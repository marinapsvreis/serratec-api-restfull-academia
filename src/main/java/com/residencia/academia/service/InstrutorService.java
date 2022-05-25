package com.residencia.academia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.academia.dto.InstrutorDTO;
import com.residencia.academia.dto.TurmaDTO;
import com.residencia.academia.entity.Instrutor;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.repository.InstrutorRepository;

@Service
public class InstrutorService {
	
		@Autowired
		private InstrutorRepository instrutorRepository;
		
		@Autowired
		private TurmaService turmaService;
		
		public List<Instrutor> findAll(){
			return instrutorRepository.findAll();
		}
		
		public Instrutor findById(Integer id) {
			return instrutorRepository.findById(id).isPresent() ? instrutorRepository.findById(id).get() : null;
		}
		
		public InstrutorDTO findInstrutorDTOById(Integer id) {
			return instrutorRepository.findById(id).isPresent() ? converterInstrutorParaDTO(instrutorRepository.findById(id).get()) : null;
		}		
		
		public Instrutor save(Instrutor instrutor) {
			return instrutorRepository.save(instrutor);
		}
		
		public Instrutor saveDTO(InstrutorDTO instrutorDTO) {
			Instrutor instrutor = converterDTOParaInstrutor(instrutorDTO);
			return instrutorRepository.save(instrutor);
		}
		
		public Instrutor update(Instrutor instrutor) {
			return instrutorRepository.save(instrutor);

		}
		
		public void delete(Integer id) {
			Instrutor instrutor = instrutorRepository.findById(id).get();
	        instrutorRepository.delete(instrutor);
		}
		
		public InstrutorDTO converterInstrutorParaDTO(Instrutor instrutor) {
			InstrutorDTO instrutorDTO = new InstrutorDTO();
			instrutorDTO.setDataNascimentoInstrutor(instrutor.getDataNascimentoInstrutor());
			instrutorDTO.setIdInstrutor(instrutor.getIdInstrutor());
			instrutorDTO.setNomeInstrutor(instrutor.getNomeInstrutor());
			instrutorDTO.setRgInstrutor(instrutor.getRgInstrutor());
			instrutorDTO.setTitulacaoInstrutor(instrutor.getTitulacaoInstrutor());
			
			List<TurmaDTO> listaTurmaDTO = new ArrayList<>();
			
			for(Turma turma : instrutor.getListaTurmas()) {
				TurmaDTO turmaDTO = turmaService.converterTurmaParaDTO(turma);
				listaTurmaDTO.add(turmaDTO);
			}
			
			instrutorDTO.setListaTurmasDTO(listaTurmaDTO);
			
			return instrutorDTO;
		}
		
		public Instrutor converterDTOParaInstrutor(InstrutorDTO instrutorDTO) {
			Instrutor instrutor = new Instrutor();
			instrutor.setDataNascimentoInstrutor(instrutorDTO.getDataNascimentoInstrutor());
			instrutor.setIdInstrutor(instrutorDTO.getIdInstrutor());
			instrutor.setNomeInstrutor(instrutorDTO.getNomeInstrutor());
			instrutor.setRgInstrutor(instrutorDTO.getRgInstrutor());
			instrutor.setTitulacaoInstrutor(instrutorDTO.getTitulacaoInstrutor());
			
			return instrutor;
		}
		
}
