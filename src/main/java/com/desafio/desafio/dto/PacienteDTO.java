package com.desafio.desafio.dto;
import java.io.Serializable;

import com.desafio.desafio.entities.*;
public class PacienteDTO implements Serializable{
    private String cpf;
    private String nome;
    private String email;


    public PacienteDTO() {
    }

    public PacienteDTO(Paciente obj) {
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setcpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}