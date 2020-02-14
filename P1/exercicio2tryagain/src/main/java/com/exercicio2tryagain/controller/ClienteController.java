/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercicio2tryagain.controller;

import com.exercicio2tryagain.model.Pessoa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 1519m
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController 
{
    List <Pessoa> pessoas = new ArrayList<>();
    
    @GetMapping
    public List<Pessoa> retornaClientes()
    {
        return pessoas;
    }
    
    @GetMapping("/{nome}")
    public Pessoa buscarPessoa(@PathVariable String nome)
    {
        for (Pessoa p : pessoas) {
            if(p.getNome().equals(nome))
            {
                return p;
            }
        }
        return null;
    }
    
    @PostMapping
    public String insereCliente(@RequestBody Pessoa p)
    {
        pessoas.add(p);
        return "Cadastrado!";
    }
    
    @PutMapping("/{nome}")
    public String atualizaCliente(@PathVariable String nome, @RequestBody Pessoa pessoa)
    {
        pessoas.forEach((p)->{
            if(p.getNome().equals(nome))
            {
                pessoas.set(pessoas.indexOf(p), pessoa);
            }
        });
        return "Atualizado!";
    }
    
    @DeleteMapping("/{nome}")
    public String excluirCliente(@PathVariable String nome)
    {
        for (Pessoa p : pessoas) {
            if(p.getNome().equals(nome))
            {
                pessoas.remove(p);
                break;
            }
        }
        return "Deletado!";
    }
}
