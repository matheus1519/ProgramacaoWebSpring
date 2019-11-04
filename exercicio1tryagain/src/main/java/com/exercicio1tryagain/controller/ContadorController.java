/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercicio1tryagain.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 1519m
 */

@RestController
@Scope("session")
@RequestMapping("/contador")
public class ContadorController {
    
    private int contador = 0;
    
    @GetMapping
    public int retornaContador()
    {
        return contador;
    }
    
    @PostMapping
    public String incrementaContador()
    {
        contador++;
        return "Sucesso ao Incrementar Contador";
    }
    
    @PutMapping
    public String zeraContador()
    {
        contador = 0;
        return "Sucesso ao Zerar Contador";
    }
    
    @DeleteMapping
    public String decrementaContador()
    {
        contador--;
        return "Sucesso ao Decrementar Contador";
    }
    
}
