/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercicio4tryagain.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author 1519m
 */
@Entity
public class Cliente extends Pessoa {
    
    private int quantidadeOcupacoes;
    
    @OneToMany
    private List<Reserva> reservas;
    
    public int calcularOcupacoes(List<Reserva> reservas)
    {
        return 0;
    }

    public int getQuantidadeOcupacoes() {
        return quantidadeOcupacoes;
    }

    public void setQuantidadeOcupacoes(int quantidadeOcupacoes) {
        this.quantidadeOcupacoes = quantidadeOcupacoes;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
    
}
