package com.desafio.desafio.service;

import java.util.List;
import java.util.Optional;

import com.desafio.desafio.repositories.PacienteRepository;
import com.desafio.desafio.dto.PacienteDTO;
import com.desafio.desafio.entities.*;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PacienteService {
  @Autowired
  private PacienteRepository repo;
  
  public List<Paciente> findAll(){
      return (List<Paciente>) repo.findAll();
  }


  public Paciente save(Paciente obj){
      return repo.save(obj);
  }

  public void delete(Paciente paciente){
      repo.delete(paciente);
  }

  public Paciente update(Paciente obj){
    Paciente newObj = obj;
    updateData(newObj, obj);
    return repo.save(newObj);
  }
  private void updateData(Paciente newObj, Paciente obj){
      newObj.setNome(obj.getNome());
      newObj.setCpf(obj.getCpf());
      newObj.setEmail(obj.getEmail());
  }


  public Paciente fromDto(PacienteDTO objDto){
      return new Paciente(objDto.getCpf(), objDto.getNome(), objDto.getEmail());
  }
}
