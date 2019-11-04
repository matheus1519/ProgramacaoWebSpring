/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercicio5.controller;

import com.exercicio5.model.Funcionario;
import com.exercicio5.repository.FuncionarioRepository;
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
@RequestMapping("/funcionarios")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioRepository funcionarios;
    
    @GetMapping()
    public List<Funcionario> list() {
        return funcionarios.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Funcionario> get(@PathVariable Long id) {
        return funcionarios.findById(id);
    }
    
    @PutMapping("/{id}")
    public boolean put(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        funcionarios.save(funcionario);
        return true;
    }
    
    @PostMapping
    public boolean post(@RequestBody Funcionario funcionario) {
        funcionarios.save(funcionario);
        return true;
    }
    
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        funcionarios.deleteById(id);
        return true;
    }
    
}
