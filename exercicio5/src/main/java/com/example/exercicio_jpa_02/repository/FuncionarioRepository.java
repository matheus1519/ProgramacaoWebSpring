package com.example.exercicio_jpa_02.repository;

import com.example.exercicio_jpa_02.model.Funcionario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
    
    public List<Funcionario> findBySetor(String setor);
}
