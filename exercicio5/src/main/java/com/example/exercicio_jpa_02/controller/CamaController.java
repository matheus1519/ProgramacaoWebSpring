package com.example.exercicio_jpa_02.controller;

import com.example.exercicio_jpa_02.model.Cama;
import com.example.exercicio_jpa_02.repository.CamaRepository;
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
@RequestMapping("/camas")
public class CamaController {
    
    @Autowired
    private CamaRepository repo;
    
    @RequestMapping( method = RequestMethod.GET)
    public List<Cama> getAll(Model model) {
        return repo.findAll();
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Optional<Cama> getOne(@PathVariable("id") Long id){
        return repo.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Cama cama){
        repo.save(cama);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void getAll(@RequestBody Cama cama, @PathVariable("id") long id){
        repo.save(cama);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void getAll(@PathVariable("id") long id){
        repo.deleteById(id);
    }    
    
}
