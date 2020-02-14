/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercicio5tryagain.controller;

import com.exercicio5tryagain.model.Funcionario;
import com.exercicio5tryagain.repository.FuncionarioRepository;
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
@RequestMapping("/funcionarios")
public class FuncionarioController 
{
    @Autowired
    FuncionarioRepository funcionarios;
    
    @GetMapping
    public List<Funcionario> listar()
    {
        return funcionarios.findAll();
    }
    
    @GetMapping("/{id}") 
    public Optional<Funcionario> listarUm(@PathVariable Long id)
    {
        return funcionarios.findById(id);
    }
    
    @PostMapping
    public Funcionario inserir(@RequestBody Funcionario fun)
    {
        return funcionarios.save(fun);
    }
    
    @PutMapping("/{id}")
    public Funcionario atualizar(@PathVariable Long id, @RequestBody Funcionario fun)
    {
        if(id == fun.getId())
        {
            return funcionarios.save(fun);
        }
        else
        {
            return null;
        }
    }
    
    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id)
    {
        funcionarios.deleteById(id);
    }
    
    
    
}
