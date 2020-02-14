package com.prova.controller;

import com.prova.model.Funcionario;
import com.prova.repository.FuncionarioRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/funcionarios")
public class FuncionariosController {

    @Autowired
    private FuncionarioRepository funcionarios;

    @GetMapping
    public ModelAndView funcView() {
        ModelAndView mv = new ModelAndView("Funcionarios");
        mv.addObject("funcionarios", funcionarios.findAll());
        return mv;
    }

    @GetMapping("/cadastrar")
    public ModelAndView funcCadView() {
        ModelAndView mv = new ModelAndView("CadastrarFuncionario");
        mv.addObject("funcionario", new Funcionario());
        return mv;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid @ModelAttribute Funcionario funcionario, BindingResult result) {
        ModelAndView mv;
        if (result.hasErrors()) {
            return "CadastrarFuncionario";
        }
        funcionarios.save(funcionario);
        return "redirect:/funcionarios";
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView funcAlterar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("CadastrarFuncionario");
        mv.addObject("funcionario", funcionarios.findById(id));
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public String funcExcluir(@PathVariable Long id) {
        funcionarios.deleteById(id);
        return "redirect:/funcionarios";

    }

}
