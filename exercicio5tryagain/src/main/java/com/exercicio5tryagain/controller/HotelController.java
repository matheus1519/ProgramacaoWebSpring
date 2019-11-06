/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercicio5tryagain.controller;

import com.exercicio5tryagain.model.Hotel;
import com.exercicio5tryagain.repository.HotelRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 1519m
 */
@RestController
@RequestMapping("/hoteis")
public class HotelController 
{
    @Autowired
    HotelRepository hoteis;
    
    @GetMapping
    public List<Hotel> listar()
    {
        return hoteis.findAll();
    }
    
    @GetMapping("/{id}") 
    public Optional<Hotel> listarUm(@PathVariable Long id)
    {
        return hoteis.findById(id);
    }
    
    @PostMapping
    public Hotel inserir(@RequestBody Hotel hot)
    {
        return hoteis.save(hot);
    }
    
    @PutMapping("/{id}")
    public Hotel atualizar(@PathVariable Long id, @RequestBody Hotel hot)
    {
        if(id == hot.getId())
        {
            return hoteis.save(hot);
        }
        else
        {
            return null;
        }
    }
    
    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id)
    {
        hoteis.deleteById(id);
    }
    
    
    
}
