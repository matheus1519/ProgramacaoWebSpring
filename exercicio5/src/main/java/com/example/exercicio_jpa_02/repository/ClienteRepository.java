package com.example.exercicio_jpa_02.repository;

import com.example.exercicio_jpa_02.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
    public int countReservasByCliente(@Param("id") Long id);
}
