package com.controller;

import java.util.Calendar;
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

import com.model.Aluno;
import com.repository.AlunoRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoController 
{
	@Autowired AlunoRepository alunos;
	
	@GetMapping
	public List<Aluno> listar()
	{
		return alunos.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Aluno> listarUm(@PathVariable Long id)
	{
		return alunos.findById(id);
	}
	
	@PostMapping
	public void cadastrar(@RequestBody Aluno aluno)
	{
		alunos.save(aluno);
	}
	
	@PutMapping("/{id}")
	public void alterar(@PathVariable Long id, @RequestBody Aluno aluno)
	{
		if(aluno.getId() == id)
		{
			alunos.save(aluno);			
		}
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id)
	{
		alunos.deleteById(id);
	}
	
	@GetMapping("/{d1}/{d2}")
	public List<Aluno> buscaAlunoBetDataNasc(@PathVariable Calendar d1, @PathVariable Calendar d2)
	{
		return alunos.buscaEntreDatas(d1, d2);
	}
	
}
