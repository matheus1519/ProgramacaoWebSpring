
package com.example.exercicio_jpa_02.model;


public class TipoQuartoQtdCama {
    private String tipo;
    private Long quantidade;

    public TipoQuartoQtdCama(String tipo, Long quantidade) {
        this.tipo = tipo;
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
