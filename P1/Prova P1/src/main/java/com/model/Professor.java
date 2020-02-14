package com.model;


import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Professor extends Pessoa 
{
	@Column(length = 14)
	private String cpf;

	@Column(length = 20)
	private String titulacao;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}
	
	
}

