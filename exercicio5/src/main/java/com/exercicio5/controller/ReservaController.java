package com.exercicio5.controller;

import com.exercicio5.model.Reserva;
import com.exercicio5.repository.ReservaRepository;
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
@RequestMapping("/reservas")
public class ReservaController {
    
    @Autowired
    private ReservaRepository reservas;
    
    @GetMapping()
    public List<Reserva> list() {
        return reservas.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Reserva> get(@PathVariable Long id) {
        return reservas.findById(id);
    }
    
    @PutMapping("/{id}")
    public boolean put(@PathVariable Long id, @RequestBody Reserva hotel) {
        reservas.save(hotel);
        return true;
    }
    
    @PostMapping
    public boolean post(@RequestBody Reserva hotel) {
        reservas.save(hotel);
        return true;
    }
    
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        reservas.deleteById(id);
        return true;
    }
    
}
