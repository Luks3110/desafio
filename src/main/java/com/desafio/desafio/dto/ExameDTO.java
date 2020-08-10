package com.desafio.desafio.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.TimeZone;
import com.desafio.desafio.entities.*;
public class ExameDTO implements Serializable{
    private Long id;
    private Paciente paciente;
    private Procedimento procedimento;
    Date dataColeta;
    Date dataEntrega;
    
    
    
    public ExameDTO() {
    }

    public ExameDTO(Exame obj) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        this.id = obj.getId();
        this.paciente = obj.getPaciente();
        this.procedimento = obj.getProcedimento();
        this.dataColeta= obj.getDataColeta();
        this.dataEntrega = obj.getDataEntrega();
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

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
}