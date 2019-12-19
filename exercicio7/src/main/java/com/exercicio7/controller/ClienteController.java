package com.exercicio7.controller;

import com.exercicio7.model.Cliente;
import com.exercicio7.repository.ClienteRepository;
import java.nio.file.Paths;
import java.util.Calendar;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clientes;

    @Autowired
    ServletContext context;

    @GetMapping
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("ListarClientes");
        mv.addObject("clientes", clientes.findAll());
        return mv;
    }

    @PostMapping("/cadastrar")
    public ModelAndView cadastrar(@RequestParam("photo") MultipartFile photo, @RequestParam("currir") MultipartFile currir, Cliente cliente) {
        ModelAndView mv = new ModelAndView("redirect:/clientes");

        if (photo.isEmpty()) {
            if (currir.isEmpty()) {
                mv.addObject("msgFile", "Foto e curriculo não carregados!");
                return mv;
            }
            mv.addObject("msgFile", "Foto não carregada!");
            return mv;
        }

        try {
            String name = Calendar.getInstance().getTimeInMillis() + photo.getOriginalFilename();
            photo.transferTo(Paths.get("C:\\Users\\1519m\\Pictures\\" + name));
//            mv.addObject("path", context.getContextPath() +"/images/"+name);
            cliente.setFoto("http://localhost:8080/images/" + name);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        try {
            String name = Calendar.getInstance().getTimeInMillis() + currir.getOriginalFilename();
            currir.transferTo(Paths.get("C:\\Users\\1519m\\Pictures\\PDF\\" + name));
//            mv.addObject("path", context.getContextPath() +"/images/"+name);
            cliente.setCurriculo("http://localhost:8080/pdf/" + name);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        clientes.save(cliente);
        return mv;
//        return "redirect:/clientes";
    }

    @GetMapping("/cadastrar")
    public ModelAndView viewCadastrar() {
        ModelAndView mv = new ModelAndView("CadastrarCliente");
        mv.addObject("cliente", new Cliente());
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        clientes.deleteById(id);
        return "redirect:/clientes/";
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("AlterarCliente");
        mv.addObject("cliente", clientes.findById(id));
        return mv;
    }

}
