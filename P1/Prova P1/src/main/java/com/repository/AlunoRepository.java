package com.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	@Query("SELECT a FROM Aluno a WHERE a.dataNasc BETWEEN ?1 AND ?2")
	public List<Aluno> buscaEntreDatas(Calendar d1, Calendar d2);
}
