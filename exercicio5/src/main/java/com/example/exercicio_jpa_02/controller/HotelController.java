    package com.example.exercicio_jpa_02.controller;

import com.example.exercicio_jpa_02.model.Cama;
import com.example.exercicio_jpa_02.model.Hotel;
import com.example.exercicio_jpa_02.model.TipoQuartoQtdCama;
import com.example.exercicio_jpa_02.repository.HotelRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hoteis")
public class HotelController {
    
    @Autowired
    private HotelRepository repo;
    
    @RequestMapping( method = RequestMethod.GET)
    public List<Hotel> getAll(Model model) {
        return repo.findAll();
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Optional<Hotel> getOne(@PathVariable("id") Long id){
        Optional<Hotel> f = repo.findById(id);
        f.get().getPessoas().get(0).setHoteis(null);
        return f;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Hotel hotel){
        repo.save(hotel);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void getAll(@RequestBody Hotel hotel, @PathVariable("id") long id){
        repo.save(hotel);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void getAll(@PathVariable("id") long id){
        repo.deleteById(id);
    } 
    
    @RequestMapping(path="/{id}/camas", method = RequestMethod.GET)
    public List<Cama> getAllCamas(@PathVariable("id") long id) {
        return repo.findAllCamas(id);
    }
    
    @RequestMapping(path="/{id}/quartos", method = RequestMethod.GET)
    public List<TipoQuartoQtdCama> getAllquartos(@PathVariable("id") long id) {
        return repo.countQuartosECamas(id);
    }
    
}
