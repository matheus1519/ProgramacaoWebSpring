package com.exercicio3.repository;

import com.exercicio3.controller.EnderecoController;
import com.exercicio3.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    
    
}
