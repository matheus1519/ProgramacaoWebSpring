/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercicio5.controller;

import com.exercicio5.model.Hotel;
import com.exercicio5.repository.HotelRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author 1519m
 */
@RestController
@RequestMapping("/hoteis")
public class HotelController {
    
    @Autowired
    private HotelRepository hoteis;
    
    @GetMapping()
    public List<Hotel> list() {
        return hoteis.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Hotel> get(@PathVariable Long id) {
        return hoteis.findById(id);
    }
    
    @PutMapping("/{id}")
    public boolean put(@PathVariable Long id, @RequestBody Hotel hotel) {
        hoteis.save(hotel);
        return true;
    }
    
    @PostMapping
    public boolean post(@RequestBody Hotel hotel) {
        hoteis.save(hotel);
        return true;
    }
    
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        hoteis.deleteById(id);
        return true;
    }
    
}
