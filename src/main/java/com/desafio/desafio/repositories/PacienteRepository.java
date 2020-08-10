package com.desafio.desafio.repositories;
import com.desafio.desafio.entities.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface PacienteRepository extends CrudRepository<Paciente, Long> {
    
}