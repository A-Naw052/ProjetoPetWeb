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

import br.com.petweb.pertweb.entity.Veterinario;
import br.com.petweb.pertweb.service.VeterinarioService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/veterinarios")
public class VeterinarioController {
    

    //Injeção de dependência da service de veterinarios 
    @Autowired
    private VeterinarioService veterinarioService;

    //Método para salvar veterinario
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Veterinario veterinario){
        veterinarioService.save(veterinario);
        return "redirect:/veterinarios/listar";
    }

    //Método paa listar todos os veterinarios
    @GetMapping("/listar")
    public String listar(Model model){
        List<Veterinario> veterinarios = veterinarioService.findAll();
        model.addAttribute("veterinarios", veterinarios);
        return "veterinario/listarVeterinario";
    }

    //Método para exibir o formulário de cadastro de veterinario
    @GetMapping("/criar")
    public String criar(Model model){
        model.addAttribute("veterinario", new Veterinario());
        return "veterinario/formularioVeterinario";
    }

    //Método para excluir um veterinario
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        veterinarioService.deleteById(id);
        return "redirect:/veterinarios/listar";
    }
    
    // Método para exibir o formulário de edição do veterinario
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Veterinario veterinario = veterinarioService.findById(id);
        model.addAttribute("veterinario", veterinario);
        return "veterinario/formularioVeterinario";
    }
    

}