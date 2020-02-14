package com.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Revista;
import com.model.RevistaRevisores;

@Repository
public interface RevistaRepository extends JpaRepository<Revista, Long> {

	List<RevistaRevisores> buscaNomeAndRevisores();
}
