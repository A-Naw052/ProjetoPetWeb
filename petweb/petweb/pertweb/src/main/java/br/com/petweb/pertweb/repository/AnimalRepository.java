package br.com.petweb.pertweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.petweb.pertweb.dto.ClienteAnimalDTO;
import br.com.petweb.pertweb.entity.Animal;

public interface AnimalRepository extends JpaRepository <Animal, Integer> {

    @Query("""
            SELECT  new  br.com.petweb.pertweb.dto.ClienteAnimalDTO(
                a.cliente.nomeCliente,
                a.cliente.telefoneCliente,
                a.nomeAnimal
            )
            FROM Animal a 
            WHERE a.cliente IS NOT NULL
            """)
            List<ClienteAnimalDTO> buscarClienteAnimal();            
    
}
