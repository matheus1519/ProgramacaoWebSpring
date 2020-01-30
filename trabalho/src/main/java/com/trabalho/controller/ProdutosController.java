package com.trabalho.controller;

import com.trabalho.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/produtos")
public class ProdutosController {
    
    @Autowired
    private ProdutoRepository produtos;
    
    @GetMapping
    public ModelAndView getAll(){
        ModelAndView mv = new ModelAndView("Produtos");
        mv.addObject("produtos",produtos.findAll());
        return mv;
    }
    
}
