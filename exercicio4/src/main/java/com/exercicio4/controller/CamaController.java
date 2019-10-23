/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercicio4.controller;

import com.exercicio4.model.Cama;
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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.exercicio4.repository.CamaRepository;

@RestController
@RequestMapping("/camas")
public class CamaController {
    
    @Autowired
    private CamaRepository camas;
    
    @GetMapping()
    public List<Cama> list() {
        return camas.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Cama> get(@PathVariable String id) {
        return camas.findById(Long.parseLong(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Cama> put(@PathVariable String id, @RequestBody Cama c) {
        camas.save(c);
        return null;
    }
    
    @PostMapping
    public ResponseEntity<Cama> post(@RequestBody Cama c) {
        camas.save(c);
        return null;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Cama> delete(@PathVariable String id) {
        camas.deleteById(Long.parseLong(id));
        return null;
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Erro Interno")
    public void handleError() {
    }
    
}
