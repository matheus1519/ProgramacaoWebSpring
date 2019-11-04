/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercicio5.controller;

import com.exercicio5.model.Cliente;
import com.exercicio5.repository.ClienteRepository;
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

@RestController
@RequestMapping("/clientes")
public class ClienteController 
{
    @Autowired
    private ClienteRepository clientes;
    
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
    
    @PutMapping("/{id}")
    public boolean atualizar(@PathVariable Long id, @RequestBody Cliente cliente)
    {
        clientes.save(cliente);
        return true;
    }
    
    @PostMapping
    public boolean inserir(@RequestBody Cliente cliente)
    {
        clientes.save(cliente);
        return true;

    }
    
    @DeleteMapping("/{id}")
    public boolean excluir(@PathVariable Long id)
    {
        clientes.deleteById(id);
        return true;
    }
    
    @GetMapping("/{id}/quantidade/reservas")
    public Long quantReservas(@PathVariable Long id)
    {
        return clientes.findCountReservas(id);
    }
}
