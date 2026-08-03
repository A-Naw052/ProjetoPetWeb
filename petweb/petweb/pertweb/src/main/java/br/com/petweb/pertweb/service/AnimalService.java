package br.com.petweb.pertweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petweb.pertweb.entity.Animal;
import br.com.petweb.pertweb.repository.AnimalRepository;

@Service
public class AnimalService {

    //injeção de dependência do repositorio
    @Autowired
    private AnimalRepository animalRepository;

    //Metodo para salvar
    public Animal save(Animal animal){
        return animalRepository.save(animal);
    }

    //Metodo para listar
    public List<Animal> findAll(){
        return animalRepository.findAll();
    }

    //Método para excluir
    public void deleteById(Integer id){
        animalRepository.deleteById(id);
    }

    //Método para encontar
    public Animal findById(Integer id){
        return animalRepository.findById(id).orElse(null);
    }
}
