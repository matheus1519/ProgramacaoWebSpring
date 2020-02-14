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

import com.model.Revista;
import com.model.RevistaRevisores;
import com.repository.RevistaRepository;

@RestController
@RequestMapping("/revistas")
public class RevistaController 
{
	@Autowired RevistaRepository revistas;
	
	@GetMapping
	public List<Revista> listar()
	{
		return revistas.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Revista> listarUm(@PathVariable Long id)
	{
		return revistas.findById(id);
	}
	
	@PostMapping
	public void cadastrar(@RequestBody Revista revista)
	{
		revistas.save(revista);
	}
	
	@PutMapping("/{id}")
	public void alterar(@PathVariable Long id, @RequestBody Revista revista)
	{
		if(revista.getId() == id)
		{
			revistas.save(revista);			
		}
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id)
	{
		revistas.deleteById(id);
	}
	
	@GetMapping("/revistanomes/revisores")
	public List<RevistaRevisores> buscaRevistaRevisores()
	{
		return revistas.buscaNomeAndRevisores();
	}
	
	
	
	
}
