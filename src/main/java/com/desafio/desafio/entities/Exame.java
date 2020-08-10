package com.desafio.desafio.entities;
import java.util.*;
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Exame implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private Long id;
  
    private Paciente paciente;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    private Procedimento procedimento;
    Date dataColeta = new Date();
    Date dataEntrega = new Date();

    public Exame(Paciente paciente, Procedimento procedimento, Date dataColeta, Date dataEntrega) {
        this.paciente = paciente;
        this.procedimento = procedimento;
        this.dataColeta = dataColeta;
        this.dataEntrega = dataEntrega;
    }

    public Paciente getPaciente() {
        return this.paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Procedimento getProcedimento() {
        return this.procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public Date getDataColeta() {
        return this.dataColeta;
    }

    public void setDataColeta(Date dataColeta) {
        this.dataColeta = dataColeta;
    }

    public Date getDataEntrega() {
        return this.dataEntrega;
    }

    public Exame() {
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", paciente='" + getPaciente() + "'" +
            ", procedimento='" + getProcedimento() + "'" +
            ", dataColeta='" + getDataColeta() + "'" +
            ", dataEntrega='" + getDataEntrega() + "'" +
            "}";
    }
}