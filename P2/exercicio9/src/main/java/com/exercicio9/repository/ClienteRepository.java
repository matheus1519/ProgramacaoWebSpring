package com.exercicio9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercicio9.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
