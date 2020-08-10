package com.desafio.desafio.repositories;
import com.desafio.desafio.entities.Procedimento;
import org.springframework.data.repository.CrudRepository;

public interface ProcedimentoRepository extends CrudRepository<Procedimento, Long> {
    
}