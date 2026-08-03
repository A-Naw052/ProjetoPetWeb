package br.com.petweb.pertweb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petweb.pertweb.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    //optional - evita retorno nulo
    Optional<Usuario> findByLoginUsuario(String loginUsuario);
}
