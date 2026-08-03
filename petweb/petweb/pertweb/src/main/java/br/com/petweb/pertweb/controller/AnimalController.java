package br.com.petweb.pertweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.petweb.pertweb.entity.Animal;
import br.com.petweb.pertweb.entity.Cliente;
import br.com.petweb.pertweb.service.AnimalService;
import br.com.petweb.pertweb.service.ClienteService;


@Controller
@RequestMapping("/animais")
public class AnimalController {

    //Injeção de dependência da service
    @Autowired
    private AnimalService animalService;

    @Autowired
    private ClienteService clienteService;

    //Método para salvar
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Animal animal){
        animalService.save(animal);
        return "redirect:/animais/listar";
    }

    //Método paa listar
    @GetMapping("/listar")
    public String listar(Model model){
        List<Animal> animais = animalService.findAll();
        model.addAttribute("animais", animais);
        return "animal/listarAnimal";
    }

    //Método para exibir o formulário de cadastro
    @GetMapping("/criar")
    public String criar(Model model){
        model.addAttribute("animal", new Animal());
        List<Cliente> clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "animal/formularioAnimal";
    }

    //Método para excluir
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        animalService.deleteById(id);
        return "redirect:/animais/listar";
    }
    
    // Método para exibir o formulário de edição
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Animal animal = animalService.findById(id);
        model.addAttribute("animal", animal);
        List<Cliente> clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "animal/formularioAnimal";
    }
    
}
