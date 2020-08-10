package com.desafio.desafio.repositories;
import com.desafio.desafio.entities.Exame;
import org.springframework.data.repository.CrudRepository;

public interface ExameRepository extends CrudRepository<Exame, Long> {
    
}