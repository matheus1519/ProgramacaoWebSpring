/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercicio5.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import org.springframework.data.jpa.repository.Query;

@Entity
@NamedQuery(name = "Cliente.findCountReservas", query = "select c.reservas from Cliente c where c.id = ?1")

public class Cliente extends Pessoa implements Serializable
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

