package com.example.exercicio_jpa_02.controller;

import com.example.exercicio_jpa_02.dto.ReservaDTO;
import com.example.exercicio_jpa_02.model.Reserva;
import com.example.exercicio_jpa_02.repository.ReservaRepository;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    
    @Autowired
    private ReservaRepository repo;
    
    @RequestMapping( method = RequestMethod.GET)
    public List<Reserva> getAll() {
        return repo.findAll();
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Optional<Reserva> getOne(@PathVariable("id") Long id){
        Optional<Reserva> r = repo.findById(id);
        r.get().getCliente().setReservas(null);
        r.get().getCliente().setHoteis(null);
        r.get().getFuncionario().setReservas(null);
        r.get().getFuncionario().setHoteis(null);
        r.get().getQuartos().get(0).setReservas(null);
        return r;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Reserva reserva){
        repo.save(reserva);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void getAll(@RequestBody Reserva reserva, @PathVariable("id") long id){
        repo.save(reserva);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void getAll(@PathVariable("id") long id){
        repo.deleteById(id);
    }    
    
    @RequestMapping(path="/consulta", method = RequestMethod.GET )
    public List<Reserva> getByClienteFuncQuarto(@RequestParam("idCliente") Long idCliente,
                                                @RequestParam("idFuncionario") Long idFuncionario,
                                                @RequestParam("idQuarto") Long idQuarto) {
        return repo.findReservaByClienteFuncQuarto(idCliente, idFuncionario, idQuarto);
    }
    
    @RequestMapping(path="/datas", method = RequestMethod.GET )
    public List<ReservaDTO> getByClienteFuncQuarto(@RequestParam("date1") Calendar date1,
                                                @RequestParam("date2") Calendar date2) {
        
        return ReservaDTO.getListaDTO(repo.findBydataReservaBetween(date1, date2));
    }
    
}
