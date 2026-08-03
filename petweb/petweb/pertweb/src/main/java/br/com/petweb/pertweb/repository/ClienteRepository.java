package br.com.petweb.pertweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petweb.pertweb.entity.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Integer> {
    
}
