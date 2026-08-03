package br.com.petweb.pertweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petweb.pertweb.entity.Animal;

public interface AnimalRepository extends JpaRepository <Animal, Integer> {
    
}
