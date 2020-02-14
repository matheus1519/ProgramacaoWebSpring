package com.example.exercicio_jpa_02.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Funcionario extends Pessoa{

    @OneToMany(mappedBy = "funcionario")
    private List<Reserva> reservas;
    
    @Column(length = 50)
    private String setor;

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
    
    
    
}
