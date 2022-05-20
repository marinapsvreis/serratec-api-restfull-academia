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
import com.residencia.academia.service.InstrutorService;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {
	
	@Autowired
	private InstrutorService instrutorService;
	
	@GetMapping
    public ResponseEntity<List<Instrutor>> findAll() {
		List<Instrutor> instrutorList = instrutorService.findAll();
        return new ResponseEntity<>(instrutorList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrutor> findBy(@PathVariable Integer id) {
    	Instrutor instrutor = instrutorService.findById(id);
        return new ResponseEntity<>(instrutor, HttpStatus.OK);
    }
	
	@PostMapping
    public ResponseEntity<Instrutor> save(@RequestBody Instrutor instrutor){
		Instrutor novoInstrutor = instrutorService.save(instrutor);
		return new ResponseEntity<>(novoInstrutor, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Instrutor> update(@RequestBody Instrutor instrutor) {
    	Instrutor novoInstrutor = instrutorService.update(instrutor);
		return new ResponseEntity<>(novoInstrutor, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
    	instrutorService.delete(id);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
