/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercicio5.repository;

import com.exercicio5.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author 1519m
 */
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    
}
