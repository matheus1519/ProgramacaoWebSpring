package com.iff.exercicio1.arquivos;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contador")
public class GeralController 
{
    int numero = 0;
    @GetMapping("/")
    public int numero()
    {
        return numero;
    }
    @PostMapping("/")
    public String incrementa()
    {
        ++numero;
        return "Sucesso";
    }
    @PutMapping("/")
    public String zera()
    {
        numero = 0;
        return "Sucesso";
    }
    @DeleteMapping("/")
    public String decrementa()
    {
        --numero;
        return "Sucesso";
    }
}
