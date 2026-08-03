package br.com.petweb.pertweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petweb.pertweb.entity.Veterinario;

public interface VeterinarioRepository extends JpaRepository <Veterinario, Integer> {
    
}
