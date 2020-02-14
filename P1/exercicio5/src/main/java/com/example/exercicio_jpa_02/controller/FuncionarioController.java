package com.example.exercicio_jpa_02.controller;

import com.example.exercicio_jpa_02.model.Funcionario;
import com.example.exercicio_jpa_02.model.Hotel;
import com.example.exercicio_jpa_02.repository.FuncionarioRepository;
import com.example.exercicio_jpa_02.repository.HotelRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioRepository repo;
    
    @RequestMapping( method = RequestMethod.GET)
    public List<Funcionario> getAll(Model model) {
        return repo.findAll();
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Optional<Funcionario> getOne(@PathVariable("id") Long id){
        return repo.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Funcionario funcionario){
        repo.save(funcionario);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void getAll(@RequestBody Funcionario funcionario, @PathVariable("id") long id){
        repo.save(funcionario);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void getAll(@PathVariable("id") long id){
        repo.deleteById(id);
    }

    @RequestMapping(path = "/setor/{setor}", method = RequestMethod.GET)
    public List<Funcionario> getBySetor(@PathVariable("setor") String setor){
        return repo.findBySetor(setor);
    }    
    
}
