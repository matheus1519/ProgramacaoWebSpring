package com.exercicio9.controller;

import java.awt.PageAttributes;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.exercicio9.model.Cliente;
import com.exercicio9.model.Telefone;
import com.exercicio9.repository.ClienteRepository;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repo;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("lista", repo.findAll());
        return "listar";
    }

    @GetMapping("/cadastrar")
    public String cad(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cadastrar";
    }

    @PostMapping("/cadastrar")
    public String save(@Valid @ModelAttribute Cliente cliente, BindingResult result,
            @RequestParam("file") MultipartFile file,
            @RequestParam("filePdf") MultipartFile filePdf, Model model) {

        if(result.hasErrors()){
            return "cadastrar";
        }       
        
        if (!file.isEmpty()) {
            if (!file.getContentType().equals(MediaType.IMAGE_JPEG_VALUE)) {
                model.addAttribute("msgFile", "Tipo de arquivo inválido");
                return "cadastrar";
            }
            try {
                String name = Calendar.getInstance().getTimeInMillis() + file.getOriginalFilename();
                file.transferTo(Paths.get("C:\\Users\\mathe\\Documents\\Imagens\\" + name));
                cliente.setFoto("/files/jpg/" + name);
            } catch (Exception ex) {
                Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (!filePdf.isEmpty()) {
            if (!filePdf.getContentType().equals(MediaType.APPLICATION_PDF_VALUE)) {
                model.addAttribute("msgFile", "Tipo de arquivo inválido");
                return "cadastrar";
            }
            try {
                String name = Calendar.getInstance().getTimeInMillis() + filePdf.getOriginalFilename();
                filePdf.transferTo(Paths.get("C:\\Users\\mathe\\Documents\\Imagens\\" + name));
                cliente.setCurriculo("/files/pdf/" + name);
            } catch (Exception ex) {
                Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        repo.save(cliente);
        return "redirect:../clientes";
    }

    @PostMapping(path = "/cadastrar", params = "addTel")
    public String addTel(@ModelAttribute Cliente cliente,
            @RequestParam("file") MultipartFile file, Model model) {
        cliente.getTelefones().add(new Telefone());
        return "cadastrar";
    }

    @GetMapping("/alterar/{id}")
    public String alt(@PathVariable("id") Long id, Model model) {
        Optional<Cliente> findById = repo.findById(id);
        if (findById.isPresent()) {
            model.addAttribute("cliente", repo.findById(id).get());
            return "cadastrar";
        } else {
            return "redirect:../clientes";
        }
    }

    @GetMapping("/deletar/{id}")
    public String del(@PathVariable("id") Long id, Model model) {
        repo.deleteById(id);
        return "redirect:../../clientes";
    }

}
