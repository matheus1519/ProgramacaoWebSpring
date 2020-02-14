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

import com.model.Publicacao;
import com.repository.PublicacaoRepository;

@RestController
@RequestMapping("/publicacoes")
public class PublicacaoController 
{
	@Autowired PublicacaoRepository publicacoes;
	
	@GetMapping
	public List<Publicacao> listar()
	{
		return publicacoes.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Publicacao> listarUm(@PathVariable Long id)
	{
		return publicacoes.findById(id);
	}
	
	@PostMapping
	public void cadastrar(@RequestBody Publicacao publicacao)
	{
		publicacoes.save(publicacao);
	}
	
	@PutMapping("/{id}")
	public void alterar(@PathVariable Long id, @RequestBody Publicacao publicacao)
	{
		if(publicacao.getId() == id)
		{
			publicacoes.save(publicacao);			
		}
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id)
	{
		publicacoes.deleteById(id);
	}
	
	@GetMapping("/publicacoes/professor/{id}")
	public List<Publicacao> buscaPublicacoesProfessor(@PathVariable Long id)
	{
		return publicacoes.buscaTodasPublicacoesDoProfessor(id);
	}
	
	@GetMapping("/publicacoes/revista/classificacao/{nome}")
	public List<Publicacao> buscaPublicacoesRevClassificacao(@PathVariable String nome)
	{
		return publicacoes.buscaPublicacoesDeRevistaPelaClassificacao(nome);
	}
	
	@GetMapping("/publicacoes/professor/{nomeProfessor}/aluno/{nomeAluno}")
	public List<Publicacao> buscaPublicacoesProfessorAluno(@PathVariable String nomeAluno, @PathVariable String nomeProfessor)
	{
		return publicacoes.buscaPublicacoesDeProfessorComAluno(nomeAluno, nomeProfessor);
	}
	
}
