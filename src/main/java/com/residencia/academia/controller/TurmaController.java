package com.residencia.academia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.academia.entity.Instrutor;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.exception.NoSuchElementFoundException;
import com.residencia.academia.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService;
	
	@GetMapping
    public ResponseEntity<List<Turma>> findAll() {
        return new ResponseEntity<>(turmaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> findBy(@PathVariable Integer id) {
    	Turma turma = turmaService.findById(id);
    	if(null == turma) {
    		throw new NoSuchElementFoundException("Não foi encontrada Turma com o id " + id);
    	}else {
    		return new ResponseEntity<>(turmaService.findById(id), HttpStatus.OK);
    	}
    }
	
	@PostMapping
    public ResponseEntity<Turma> save(@RequestBody Turma turma){
		return new ResponseEntity<>(turmaService.save(turma), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Turma> update(@RequestBody Turma turma) {
    	Turma turmaFound = turmaService.findById(turma.getIdTurma());
    	if (turmaFound == null) {
    		throw new NoSuchElementFoundException("Não foi encontrada a Turma com o id " + turma.getIdTurma());
        }
        else {
        	return new ResponseEntity<>(turmaService.update(turma), HttpStatus.OK);
        } 		
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
    	Turma turma = turmaService.findById(id);
    	if(null == turma) {
    		throw new NoSuchElementFoundException("Não foi encontrada a Turma com o id " + id);
    	}else {
    		turmaService.delete(id);
            return new ResponseEntity<>("", HttpStatus.OK);
    	}    	
    }
}