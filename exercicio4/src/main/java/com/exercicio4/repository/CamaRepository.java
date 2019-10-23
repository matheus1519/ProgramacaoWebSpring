/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercicio4.repository;

import com.exercicio4.model.Cama;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CamaRepository extends JpaRepository<Cama, Long> {
    
}
