package com.exercicio8.controller;

import com.exercicio8.model.Cliente;
import com.exercicio8.repository.ClienteRepository;
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
import com.exercicio8.controller.ImageController;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;

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
    public ModelAndView cadastrar(@Valid Cliente cliente,
            BindingResult result,
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("currir") MultipartFile currir) {
        ModelAndView mv = new ModelAndView("redirect:/clientes");

        if(result.hasErrors()){
            ModelAndView mvErro = new ModelAndView("CadastrarCliente");
            mvErro.addObject("cliente", cliente);
            return mvErro;
        }
        
        if (photo.isEmpty()) {
            if (currir.isEmpty()) {
                mv.addObject("msgFile", "Foto e curriculo não carregados!");
                return mv;
            }
            mv.addObject("msgFile", "Foto não carregada!");
            return mv;
        }

        ImageController.salvarFoto(photo, cliente);
        PdfController.salvarPdf(currir, cliente);

        clientes.save(cliente);
        return mv;
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
    public ModelAndView alterarView(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("AlterarCliente");
        Optional<Cliente> cliente = clientes.findById(id);
        mv.addObject("cliente", cliente);
        System.out.println(cliente.get().getCurriculo() + " " + cliente.get().getFoto());

        return mv;
    }

    @PostMapping("/alterar")
    public ModelAndView alterar(
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("currir") MultipartFile currir,
            @ModelAttribute Cliente cliente) {
        ModelAndView mv = new ModelAndView("redirect:/clientes");

        Optional<Cliente> clienteTemp = clientes.findById(cliente.getId());

        if (!photo.isEmpty()) {
            ImageController.salvarFoto(photo, cliente);
        } else {
            cliente.setFoto(clienteTemp.get().getFoto());
        }

        if (!currir.isEmpty()) {
            PdfController.salvarPdf(currir, cliente);
        } else {
            cliente.setCurriculo(clienteTemp.get().getCurriculo());
        }

        clientes.save(cliente);

        return mv;
    }

}
