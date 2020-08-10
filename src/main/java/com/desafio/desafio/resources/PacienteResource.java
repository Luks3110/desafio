package com.desafio.desafio.resources;

import com.desafio.desafio.entities.Exame;
import com.desafio.desafio.entities.Paciente;
import com.desafio.desafio.service.PacienteService;

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
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value= "/Pacientes")
public class PacienteResource {
    @Autowired
    private PacienteService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PacienteDTO>> findAll(){
        List<Paciente> list = service.findAll();
        List<PacienteDTO> listDto = list.stream().map(x -> new PacienteDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody PacienteDTO objDto){
        Paciente obj = service.fromDto(objDto);
        obj = service.save(obj);
        return ResponseEntity.ok().build();
    }
}