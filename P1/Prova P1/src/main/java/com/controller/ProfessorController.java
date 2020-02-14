package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Professor;
import com.repository.ProfessorRepository;

@RestController
@RequestMapping("/professores")
public class ProfessorController 
{
	@Autowired ProfessorRepository professores;
	
	@GetMapping
	public List<Professor> listar()
	{
		return professores.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Professor> listarUm(@PathVariable Long id)
	{
		return professores.findById(id);
	}
	
	@PostMapping
	public void cadastrar(@RequestBody Professor professor)
	{
		professores.save(professor);
	}
	
	@PutMapping("/{id}")
	public void alterar(@PathVariable Long id, @RequestBody Professor professor)
	{
		if(professor.getId() == id)
		{
			professores.save(professor);			
		}
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id)
	{
		professores.deleteById(id);
	}
	
	
}
