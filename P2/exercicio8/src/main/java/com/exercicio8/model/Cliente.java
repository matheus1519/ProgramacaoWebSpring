package com.exercicio8.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode estar em branco!")
    @Size(min = 8, max = 100, message = "O nome deve conter de 8 a 100 caracteres!")
    private String nome;
    
    @NotEmpty(message = "O telefone é obrigatório!")
    @Size(min = 1, max = 3)
    @OneToMany(cascade =CascadeType.ALL, orphanRemoval = true)
    private List<Telefone> telefones  = new ArrayList<>();
    
    @OneToOne(cascade =CascadeType.ALL, orphanRemoval = true)
    private Endereco endereco;

//    @DateTimeFormat
    @Temporal(TemporalType.DATE)
    private Calendar dtNasc;
    
    private String foto;

    public Calendar getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Calendar dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }
    
    private String curriculo;

    
    

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

 
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
    
    
}
