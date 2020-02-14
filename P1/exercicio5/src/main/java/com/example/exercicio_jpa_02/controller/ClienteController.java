package com.example.exercicio_jpa_02.controller;

import com.example.exercicio_jpa_02.model.Cliente;
import com.example.exercicio_jpa_02.repository.ClienteRepository;
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
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteRepository repo;
    
    @RequestMapping( method = RequestMethod.GET)
    public List<Cliente> getAll() {
        return repo.findAll();
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Optional<Cliente> getOne(@PathVariable("id") Long id){
        return repo.findById(id);
    }
    
    @RequestMapping( method = RequestMethod.POST)
    public void add(@RequestBody Cliente cliente){
        repo.save(cliente);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void getAll(@RequestBody Cliente cliente, @PathVariable("id") long id){
        repo.save(cliente);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void getAll(@PathVariable("id") long id){
        repo.deleteById(id);
    }

    @RequestMapping(path = "/{id}/countReservas", method = RequestMethod.GET)
    public int getCountReserva(@PathVariable("id") Long id){
        return repo.countReservasByCliente(id);
    }     
    
}
