/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.exercicio2.controller;

import com.example.exercicio2.model.Pessoa;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
public class PessoaController {
    
    private List<Pessoa> pessoas = new ArrayList<>();
    
    @RequestMapping(value = "/clientes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Pessoa> listar()
    {
        return pessoas;
    }
    
    @RequestMapping(value = "/clientes/{nome}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Pessoa listarNome(@PathVariable("nome") String nome)
    {
        for (Pessoa pessoa : pessoas) {
            if(pessoa.getNome().equals(nome))
            {
                return pessoa;
            }
        }
        return null;
    }
    
    @RequestMapping(value = "/clientes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Pessoa cadastrar(@RequestBody Pessoa pessoa)
    {
        pessoas.add(pessoa);
        return pessoa;
    }
    
    @RequestMapping(value = "/clientes/{nome}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public boolean alterar(@RequestBody Pessoa pessoa, @PathVariable("nome") String nome)
    {
        for(Pessoa pess : pessoas)
        {
            if(pess.getNome().equals(nome))
            {
                pessoas.set(pessoas.indexOf(pess), pessoa);
                return true;
            }
        }
        return false;
    }
    
    @RequestMapping(value="/clientes/{nome}", method = RequestMethod.DELETE)
    public boolean deletar(@PathVariable("nome") String nome)
    {
        for (Pessoa pessoa : pessoas) 
        {
            if(pessoa.getNome().equals(nome))
            {
                return pessoas.remove(pessoa);
            }
        }
        return false;
    }
    
}
