package com.desafio.desafio.service;

import java.util.List;
import java.util.Optional;

import com.desafio.desafio.repositories.ProcedimentoRepository;
import com.desafio.desafio.dto.ProcedimentoDTO;
import com.desafio.desafio.entities.*;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProcedimentoService {
  @Autowired
  private ProcedimentoRepository repo;
  
  public List<Procedimento> findAll(){
      return (List<Procedimento>) repo.findAll();
  }


  public Procedimento save(Procedimento obj){
      return repo.save(obj);
  }

  public void delete(Long id){
      repo.findById(id);
      repo.deleteById(id);
  }

  public Procedimento update(Procedimento obj){
    
    Optional<Procedimento> optionalObj = repo.findById(obj.getId());
    Procedimento newObj = optionalObj.get();
    updateData(newObj, obj);
    return repo.save(newObj);
  }
  private void updateData(Procedimento newObj, Procedimento obj){
      newObj.setNome(obj.getNome());
      newObj.setPrazo(obj.getPrazo());
  }


  public Procedimento fromDto(ProcedimentoDTO objDto){
      return new Procedimento(objDto.getId(), objDto.getNome(), objDto.getPrazo());
  }
}
