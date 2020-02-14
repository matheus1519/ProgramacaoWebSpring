/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercicio5tryagain.controller;

import com.exercicio5tryagain.model.Reserva;
import com.exercicio5tryagain.repository.ReservaRepository;
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
@RequestMapping("/reservas")
public class ReservaController 
{
    @Autowired
    ReservaRepository reservas;
    
    @GetMapping
    public List<Reserva> listar()
    {
        return reservas.findAll();
    }
    
    @GetMapping("/{id}") 
    public Optional<Reserva> listarUm(@PathVariable Long id)
    {
        return reservas.findById(id);
    }
    
    @PostMapping
    public Reserva inserir(@RequestBody Reserva res)
    {
        return reservas.save(res);
    }
    
    @PutMapping("/{id}")
    public Reserva atualizar(@PathVariable Long id, @RequestBody Reserva res)
    {
        if(id == res.getId())
        {
            return reservas.save(res);
        }
        else
        {
            return null;
        }
    }
    
    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id)
    {
        reservas.deleteById(id);
    }
    
    
    
}
