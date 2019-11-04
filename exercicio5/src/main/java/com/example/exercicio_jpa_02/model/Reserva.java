package com.example.exercicio_jpa_02.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name = "Reserva.findReservaByClienteFuncQuarto", 
        query = "SELECT r FROM Reserva r JOIN r.cliente c JOIN r.funcionario f JOIN r.quartos q WHERE c.id = :idC AND f.id = :idF AND q.id = :idQ")
public class Reserva implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar dataReserva;
    
    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    private Funcionario funcionario;
    
    @ManyToMany
    private List<Quarto> quartos;

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<Quarto> quartos) {
        this.quartos = quartos;
    }
    
    
    
    
}
