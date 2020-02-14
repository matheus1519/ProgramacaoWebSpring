package com.repository;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Publicacao;

@Repository
public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {
	
	public List<Publicacao> buscaTodasPublicacoesDoProfessor(@PathParam("id") Long id);
	
	public List<Publicacao> buscaPublicacoesDeRevistaPelaClassificacao(@PathParam("classificacao") String classificacao);

	public List<Publicacao> buscaPublicacoesDeProfessorComAluno(@PathParam("nomeAluno") String nomeAluno,@PathParam("nomeProfessor") String nomeProfessor);
}
