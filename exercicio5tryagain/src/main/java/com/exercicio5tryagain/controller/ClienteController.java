/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercicio5tryagain.controller;

import com.exercicio5tryagain.model.Cliente;
import com.exercicio5tryagain.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.Entity;
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
@RequestMapping("/clientes")
public class ClienteController 
{
    @Autowired
    ClienteRepository clientes;
    
    @GetMapping
    public List<Cliente> listar()
    {
        return clientes.findAll();
    }
    
    @GetMapping("/{id}") 
    public Optional<Cliente> listarUm(@PathVariable Long id)
    {
        return clientes.findById(id);
    }
    
    @PostMapping
    public Cliente inserir(@RequestBody Cliente cli)
    {
        return clientes.save(cli);
    }
    
    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cli)
    {
        if(id == cli.getId())
        {
            return clientes.save(cli);
        }
        else
        {
            return null;
        }
    }
    
    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id)
    {
        clientes.deleteById(id);
    }
    
    @GetMapping("/{id}/quantidade/reservas")
    public int quantReservas(@PathVariable Long id)
    {
        return clientes.countReservas(id);
    }
    
    
}
