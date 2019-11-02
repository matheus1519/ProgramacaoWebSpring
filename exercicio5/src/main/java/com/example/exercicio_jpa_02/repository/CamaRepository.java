package com.example.exercicio_jpa_02.repository;

import com.example.exercicio_jpa_02.model.Cama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamaRepository extends JpaRepository<Cama, Long>{
    
}
