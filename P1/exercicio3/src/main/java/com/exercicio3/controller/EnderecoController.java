package com.exercicio3.controller;

import com.exercicio3.model.Endereco;
import com.exercicio3.repository.EnderecoRepository;
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

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    
    @Autowired
    private EnderecoRepository enderecos;
    
    @GetMapping()
    public List<Endereco> listar() {
        return enderecos.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Endereco> get(@PathVariable String id) {
        return enderecos.findById(Long.parseLong(id));
    }
    
    @PutMapping("/{id}")
    public void atualizar(@PathVariable String id, @RequestBody Endereco endereco) {
        endereco.setId(Long.parseLong(id));
        enderecos.save(endereco);
    }
    
    @PostMapping
    public void inserir(@RequestBody Endereco endereco) {
        enderecos.save(endereco);
    }
    
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable String id) {
        enderecos.deleteById(Long.parseLong(id));
    }
    
}
