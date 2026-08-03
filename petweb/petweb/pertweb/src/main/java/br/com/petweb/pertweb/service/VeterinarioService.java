package br.com.petweb.pertweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petweb.pertweb.entity.Veterinario;
import br.com.petweb.pertweb.repository.VeterinarioRepository;

@Service
public class VeterinarioService {
    
    //injeção de dependência do repositorio de Veterinarios 
    @Autowired
    private VeterinarioRepository VeterinarioRepository;

    //Metodo para salvar um Veterinario 
    public Veterinario save(Veterinario veterinario){
        return VeterinarioRepository.save(veterinario);
    }

    //Metodo para listar os Veterinarios
    public List<Veterinario> findAll(){
        return VeterinarioRepository.findAll();
    }

    //Método para excluir um Veterinario por id
    public void deleteById(Integer id){
        VeterinarioRepository.deleteById(id);
    }

    //Método para encontar um Veterinario por id
    public Veterinario findById(Integer id){
        return VeterinarioRepository.findById(id).orElse(null);
    }
}
