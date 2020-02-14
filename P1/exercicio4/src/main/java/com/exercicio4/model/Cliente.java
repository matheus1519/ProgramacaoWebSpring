/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercicio4.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Pessoa
{

    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas;
    private int quantidadeOcupacoes;

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

