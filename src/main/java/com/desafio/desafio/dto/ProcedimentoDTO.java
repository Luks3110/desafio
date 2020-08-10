package com.desafio.desafio.dto;
import java.io.Serializable;

import com.desafio.desafio.entities.*;
public class ProcedimentoDTO implements Serializable{
    private Long id;
    private String nome;
    private int prazo;


    public ProcedimentoDTO() {
    }

    public ProcedimentoDTO(Procedimento obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.prazo = obj.getPrazo();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPrazo() {
        return this.prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

}