package com.example.exercicio_jpa_02.dto;

import com.example.exercicio_jpa_02.model.Reserva;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ReservaDTO {
    private Long id;
    private Calendar dataReserva;

    public ReservaDTO() {
    }
    
    public ReservaDTO(Long id, Calendar dataReserva) {
        this.id = id;
        this.dataReserva = dataReserva;
    }
    
    public static List<ReservaDTO> getListaDTO(List<Reserva> lista){
        List<ReservaDTO> listaDTO = new ArrayList<>();
        for(Reserva r : lista){
            listaDTO.add(new ReservaDTO(r.getId(), r.getDataReserva()));
        }
        return listaDTO;
    }
    
    public Reserva convertObjectReserva(){
        Reserva r = new Reserva();
        r.setId(id);
        r.setDataReserva(dataReserva);
        return r;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Calendar dataReserva) {
        this.dataReserva = dataReserva;
    }
    
    
    
}
