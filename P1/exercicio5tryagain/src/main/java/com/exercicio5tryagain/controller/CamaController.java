/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercicio5tryagain.controller;

import com.exercicio5tryagain.model.Cama;
import com.exercicio5tryagain.repository.CamaRepository;
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
@RequestMapping("/camas")
public class CamaController 
{
    @Autowired
    CamaRepository camas;
    
    @GetMapping
    public List<Cama> listar()
    {
        return camas.findAll();
    }
    
    @GetMapping("/{id}") 
    public Optional<Cama> listarUm(@PathVariable Long id)
    {
        return camas.findById(id);
    }
    
    @PostMapping
    public Cama inserir(@RequestBody Cama cama)
    {
        return camas.save(cama);
    }
    
    @PutMapping("/{id}")
    public Cama atualizar(@PathVariable Long id, @RequestBody Cama cama)
    {
        if(id == cama.getId())
        {
            return camas.save(cama);
        }
        else
        {
            return null;
        }
    }
    
    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id)
    {
        camas.deleteById(id);
    }
    
    
    
}
