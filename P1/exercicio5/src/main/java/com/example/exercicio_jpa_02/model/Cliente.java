package com.example.exercicio_jpa_02.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Cliente.countReservasByCliente", query = "SELECT COUNT(r) FROM Cliente c JOIN c.reservas r WHERE c.id = :id")
public class Cliente extends Pessoa{

    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas;
    
    @Column
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
