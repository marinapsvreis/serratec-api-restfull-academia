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

import com.residencia.academia.entity.Atividade;
import com.residencia.academia.exception.NoSuchElementFoundException;
import com.residencia.academia.service.AtividadeService;

@RestController
@RequestMapping("/atividade")
public class AtividadeController {
	
	@Autowired
	private AtividadeService atividadeService;
	
	@GetMapping
    public ResponseEntity<List<Atividade>> findAll() {
		List<Atividade> atividadeList = atividadeService.findAll();
        return new ResponseEntity<>(atividadeList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atividade> findBy(@PathVariable Integer id) {
    	Atividade atividade = atividadeService.findById(id);
    	if (atividade == null) {
    		throw new NoSuchElementFoundException("Não foi encontrado o Atividade com o id " + id);
        }
        else {
            return new ResponseEntity<>(atividadeService.findById(id), HttpStatus.OK);
        }  
    }
	
	@PostMapping
    public ResponseEntity<Atividade> save(@RequestBody Atividade atividade){
		Atividade novoAtividade = atividadeService.save(atividade);
		return new ResponseEntity<>(novoAtividade, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Atividade> update(@RequestBody Atividade atividade) {
    	Atividade atividadeFound = atividadeService.findById(atividade.getIdAtividade());
    	if (atividadeFound == null) {
    		throw new NoSuchElementFoundException("Não foi encontrado o Atividade com o id " + atividade.getIdAtividade());
        }
        else {
        	Atividade novoAtividade = atividadeService.update(atividade);
    		return new ResponseEntity<>(novoAtividade, HttpStatus.OK);
        }     	
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
    	Atividade atividade = atividadeService.findById(id);
    	if (atividade == null) {
    		throw new NoSuchElementFoundException("Não foi encontrado o Atividade com o id " + id);
        }
        else {
        	atividadeService.delete(id);
            return new ResponseEntity<>("", HttpStatus.OK);
        }    	
    }
}
