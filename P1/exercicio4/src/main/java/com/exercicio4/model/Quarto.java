/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercicio4.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Quarto 
{

    @ManyToMany(mappedBy = "quartos")
    private List<Reserva> reservas;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false, length = 80)
    private String tipo;
    
    @Column(name="ocupado")
    private boolean isOcupado;
    
    private int numeroQuarto;
    
    @OneToMany
    @JoinColumn(name = "quarto_id")
    private List<Cama> camas;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isIsOcupado() {
        return isOcupado;
    }

    public void setIsOcupado(boolean isOcupado) {
        this.isOcupado = isOcupado;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Cama> getCamas() {
        return camas;
    }

    public void setCamas(List<Cama> camas) {
        this.camas = camas;
    }
    
    
    
}
