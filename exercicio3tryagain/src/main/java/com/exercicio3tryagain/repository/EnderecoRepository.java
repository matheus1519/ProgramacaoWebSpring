/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercicio3tryagain.repository;

import com.exercicio3tryagain.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 1519m
 */
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
}
