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

import com.residencia.academia.entity.Turma;
import com.residencia.academia.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService;
	
	@GetMapping
    public ResponseEntity<List<Turma>> findAll() {
		List<Turma> turmaList = turmaService.findAll();
        return new ResponseEntity<>(turmaList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> findBy(@PathVariable Integer id) {
    	Turma turma = turmaService.findById(id);
        return new ResponseEntity<>(turma, HttpStatus.OK);
    }
	
	@PostMapping
    public ResponseEntity<Turma> save(@RequestBody Turma turma){
		Turma novaTurma = turmaService.save(turma);
		return new ResponseEntity<>(novaTurma, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Turma> update(@RequestBody Turma turma) {
    	Turma novaTurma = turmaService.update(turma);
		return new ResponseEntity<>(novaTurma, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
    	turmaService.delete(id);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}