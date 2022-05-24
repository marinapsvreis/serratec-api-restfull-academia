package com.residencia.academia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.academia.entity.Turma;
import com.residencia.academia.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	public List<Turma> findAll(){
		return turmaRepository.findAll();
	}
	
	public Turma findById(Integer id) {
		return turmaRepository.findById(id).isPresent() ?
			turmaRepository.findById(id).get() : null;
	}
	
	public Turma save(Turma turma) {
		return turmaRepository.save(turma);
	}
	
	public Turma update(Turma turma) {
		return turmaRepository.save(turma);
	}
	
	public void delete(Integer id) {
		turmaRepository.deleteById(id);
	}
	
}
