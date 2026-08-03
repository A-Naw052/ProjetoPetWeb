package br.com.petweb.pertweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petweb.pertweb.entity.Consulta;

public interface ConsultaRepository extends JpaRepository <Consulta, Integer> {
    
}
