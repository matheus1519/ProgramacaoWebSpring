package com.prova.repository;

import com.prova.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aluno
 */
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
}
