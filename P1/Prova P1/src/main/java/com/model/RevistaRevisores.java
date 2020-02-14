package com.model;

import java.util.Collection;
import java.util.List;

public class RevistaRevisores 
{
	private String revNome;
	
	private Collection<Professor> revRevisores;
	
	public String getRevNome() {
		return revNome;
	}
	
	public RevistaRevisores(String revNome, Collection<Professor> revRevisores) {
		this.revNome = revNome;
		this.revRevisores = revRevisores;
	}

	public void setRevNome(String revNome) {
		this.revNome = revNome;
	}
	public Collection<Professor> getRevRevisores() {
		return revRevisores;
	}
	public void setRevRevisores(Collection<Professor> revRevisores) {
		this.revRevisores = revRevisores;
	}
	
	
}
