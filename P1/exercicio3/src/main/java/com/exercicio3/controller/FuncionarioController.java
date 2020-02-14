package com.exercicio3.controller;

import com.exercicio3.model.Funcionario;
import com.exercicio3.repository.FuncionarioRepository;
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
@RequestMapping("/funcionarios")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioRepository funcionarios;
    
    @GetMapping()
    public List<Funcionario> listar() {
        return funcionarios.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Funcionario> listarUm(@PathVariable String id) {
        return funcionarios.findById(Long.parseLong(id));
    }
    
    @PutMapping("/{id}")
    public String atualizar(@PathVariable String id, @RequestBody Funcionario funcionario) {
        funcionario.setId(Long.parseLong(id));
        funcionarios.save(funcionario);
        return "Atualizado!";
    }
    
    @PostMapping
    public String cadastrar(@RequestBody Funcionario funcionario) {
        funcionarios.save(funcionario);
        return "Cadastrado!";
    }
    
    @DeleteMapping("/{id}")
    public String excluir(@PathVariable String id) {
        funcionarios.deleteById(Long.parseLong(id));
        return "Excluido!";
    }
    
}
