package com.trabalho.controller;

import com.trabalho.repository.ProdutoRepository;
import com.trabalho.model.Produto;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/gerenciar")
public class GerenciaProdutoController {

    @Autowired
    private ProdutoRepository produtos;

    @GetMapping
    public ModelAndView getAll() {
        ModelAndView mv = new ModelAndView("Gerenciar");
        mv.addObject("produtos", produtos.findAll());
        mv.addObject("produto", new Produto());
        return mv;
    }

    @PostMapping
    public String create(@ModelAttribute Produto produto, @RequestParam("photo") MultipartFile photo) {
        ImageController.salvarFoto(photo, produto);
        produtos.save(produto);
        return "redirect:/gerenciar";
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView update(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("Gerenciar");
        Optional<Produto> prod = produtos.findById(id);
        mv.addObject("produtos", produtos.findAll());
        mv.addObject("produto", prod);
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public String delete(@PathVariable Long id) {
        produtos.deleteById(id);
        return "redirect:/gerenciar";
    }

}
