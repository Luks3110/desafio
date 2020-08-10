package com.desafio.desafio.resources;

import com.desafio.desafio.entities.Exame;
import com.desafio.desafio.entities.Procedimento;
import com.desafio.desafio.service.ProcedimentoService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.desafio.desafio.dto.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value= "/Procedimentos")
public class ProcedimentoResource {
    @Autowired
    private ProcedimentoService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ProcedimentoDTO>> findAll(){
        List<Procedimento> list = service.findAll();
        List<ProcedimentoDTO> listDto = list.stream().map(x -> new ProcedimentoDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody ProcedimentoDTO objDto){
        Procedimento obj = service.fromDto(objDto);
        obj = service.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody ProcedimentoDTO objDto, @PathVariable Long id){
        Procedimento obj = service.fromDto(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}