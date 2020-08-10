package com.desafio.desafio.service;

import java.util.List;
import java.util.Optional;

import com.desafio.desafio.repositories.*;
import com.desafio.desafio.dto.ExameDTO;
import com.desafio.desafio.entities.*;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
@Service
public class ExameService {
  @Autowired
  private ExameRepository repo;
  
  public List<Exame> findAll(){
      return (List<Exame>) repo.findAll();
  }


  public Exame save(Exame obj){
      return repo.save(obj);
  }


  public void delete(Exame Exame){
    repo.delete(Exame);
}

public Exame update(Exame obj){
  Exame newObj = obj;
  updateData(newObj, obj);
  return repo.save(newObj);
}
private void updateData(Exame newObj, Exame obj){
    newObj.setPaciente(obj.getPaciente());
    newObj.setProcedimento(obj.getProcedimento());
    newObj.setDataColeta(obj.getDataColeta());
    newObj.setDataColeta(obj.getDataEntrega());
}


public Exame fromDto(ExameDTO objDto){
    return new Exame(objDto.getPaciente(), objDto.getProcedimento(), objDto.getDataColeta(), objDto.getDataEntrega());
}
}
