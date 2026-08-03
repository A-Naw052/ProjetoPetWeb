package br.com.petweb.pertweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.petweb.pertweb.entity.Usuario;
import br.com.petweb.pertweb.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;//cripitografa a senha

    public Usuario save(Usuario usuario){
        //Criptografar a senha antes de salvar
        //get - pegando a senha por encode e setando por set
        usuario.setSenhaUsuario(passwordEncoder.encode(usuario.getSenhaUsuario()));
        return usuarioRepository.save(usuario);
    }

    

}
