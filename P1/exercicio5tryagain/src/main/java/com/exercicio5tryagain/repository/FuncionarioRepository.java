/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercicio5tryagain.repository;

import com.exercicio5tryagain.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 1519m
 */
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
    
}
