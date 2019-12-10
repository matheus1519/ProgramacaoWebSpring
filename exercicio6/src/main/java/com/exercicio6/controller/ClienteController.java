package com.exercicio6.controller;

import com.exercicio6.model.Cliente;
import com.exercicio6.repository.ClienteRepository;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    
    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public ModelAndView cadastrar(@RequestParam("file") MultipartFile file, Cliente cliente) {
        ModelAndView mv = new ModelAndView("CadastrarCliente");
        
        if(file.isEmpty()){
            mv.addObject("msgFile", "Foto não carregada!");
            return mv;
        }
        
        try{
            String name = Calendar.getInstance().getTimeInMillis()+file.getOriginalFilename();
            file.transferTo(Paths.get("C:\\Users\\1519m\\Pictures\\"+name));
            mv.addObject("path", context.getContextPath() +"/images/"+name);
            cliente.setFoto("http://localhost:8080/images/"+name);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        
        
        clientes.save(cliente);
        return mv;
//        return "redirect:/clientes";
    }
    
    @GetMapping("/cadastrar")
    public ModelAndView viewCadastrar() {
        ModelAndView mv = new ModelAndView("CadastrarCliente");
        mv.addObject("cliente",new Cliente());
        return mv;
    }
    
        
    
    
}
