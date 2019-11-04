package com.exercicio5.controller;

import com.exercicio5.model.Cama;
import com.exercicio5.repository.CamaRepository;
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
@RequestMapping("/camas")
public class CamaController {
    
    @Autowired
    private CamaRepository camas;
    
    @GetMapping()
    public List<Cama> list() {
        return camas.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Cama> get(@PathVariable Long id) {
        return camas.findById(id);
    }
    
    @PutMapping("/{id}")
    public boolean put(@PathVariable Long id, @RequestBody Cama hotel) {
        camas.save(hotel);
        return true;
    }
    
    @PostMapping
    public boolean post(@RequestBody Cama hotel) {
        camas.save(hotel);
        return true;
    }
    
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        camas.deleteById(id);
        return true;
    }
    
}
