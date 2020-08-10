package com.desafio.desafio.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Procedimento implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 1L;
    private String nome;
    private int prazo;


    public Procedimento(Long id, String nome, int prazo) {
        this.id = id;
        this.nome = nome;
        this.prazo = prazo;
    }

    public Procedimento() {
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", prazo='" + getPrazo() + "'" +
            "}";
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Procedimento)) {
            return false;
        }
        Procedimento procedimento = (Procedimento) o;
        return Objects.equals(id, procedimento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}