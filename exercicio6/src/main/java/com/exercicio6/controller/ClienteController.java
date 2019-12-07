package com.exercicio6.controller;

import com.exercicio6.model.Cliente;
import com.exercicio6.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteRepository clientes;
    
    @GetMapping
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("ListarClientes");
        mv.addObject("clientes", clientes.findAll());
        return mv;
    }
    
    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST,  consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String cadastrar(Cliente cliente) {
        clientes.save(cliente);
        return "redirect:/clientes";
    }
    
    @GetMapping("/cadastrar")
    public ModelAndView viewCadastrar() {
        ModelAndView mv = new ModelAndView("CadastrarCliente");
        mv.addObject("cliente",new Cliente());
        return mv;
    }
    
}
