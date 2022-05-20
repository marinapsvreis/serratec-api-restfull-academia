package com.residencia.academia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.academia.entity.Instrutor;
import com.residencia.academia.repository.InstrutorRepository;

@Service
public class InstrutorService {
	
		@Autowired
		private InstrutorRepository instrutorRepository;
		
		public List<Instrutor> findAll(){
			return instrutorRepository.findAll();
		}
		
		public Instrutor findById(Integer id) {
			return instrutorRepository.findById(id).get();
		}
		
		public Instrutor save(Instrutor instrutor) {
			return instrutorRepository.save(instrutor);
		}
		
		public Instrutor update(Instrutor instrutor) {
			return instrutorRepository.save(instrutor);

		}
		
		public void delete(Integer id) {
			Instrutor instrutor = instrutorRepository.findById(id).get();
	        instrutorRepository.delete(instrutor);
		}
		
}
