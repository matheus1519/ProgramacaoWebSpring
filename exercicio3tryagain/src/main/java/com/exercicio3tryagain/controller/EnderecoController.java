/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercicio3tryagain.controller;

import com.exercicio3tryagain.model.Endereco;
import com.exercicio3tryagain.repository.EnderecoRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author 1519m
 */
@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    
    @Autowired
    EnderecoRepository enderecos;
    
    @GetMapping()
    public List<Endereco> list() {
        return enderecos.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Endereco> get(@PathVariable Long id) {
        return enderecos.findById(id);
    }
    
    @PutMapping("/{id}")
    public Endereco put(@PathVariable String id, @RequestBody Endereco endereco) {
        return enderecos.save(endereco);
    }
    
    @PostMapping
    public Endereco post(@RequestBody Endereco endereco) {
        return enderecos.save(endereco);
    }
    
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        enderecos.deleteById(id);
        return true;
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Erro Interno")
    public void handleError() {
    }
    
}
