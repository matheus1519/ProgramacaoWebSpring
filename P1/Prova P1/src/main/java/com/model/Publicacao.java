package com.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQuery(name = "Publicacao.buscaTodasPublicacoesDoProfessor", query = "SELECT p FROM Publicacao p JOIN p.professores prof WHERE prof.id = :id")
@NamedQuery(name = "Publicacao.buscaPublicacoesDeRevistaPelaClassificacao", query = "SELECT pub FROM Publicacao pub WHERE pub.revista.classificacao = :classificacao")
@NamedQuery(name = "Publicacao.buscaPublicacoesDeProfessorComAluno", query="SELECT pub FROM Publicacao pub JOIN pub.alunos alu JOIN pub.professores prof where alu.nome = :nomeAluno AND prof.nome = :nomeProfessor")
public class Publicacao 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 200)
	private String titulo;

	@Column(name = "date_pub", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	@Column(length = 20)
	private String tipo;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Aluno> alunos;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Professor> professores;
	
	@ManyToOne
	private Revista revista;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public Revista getRevistas() {
		return revista;
	}

	public void setRevistas(Revista revistas) {
		this.revista = revistas;
	}
	
	
	
}

