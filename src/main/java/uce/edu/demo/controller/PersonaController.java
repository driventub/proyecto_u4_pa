package uce.edu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uce.edu.demo.repository.modelo.Persona;
import uce.edu.demo.service.IPersonaService;

@Controller
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @GetMapping("/buscar")
    public String buscarTodos(Model modelo) {
        List<Persona> lista = this.personaService.buscarTodos();
        modelo.addAttribute("lista", lista);
        return "p_todos";
    }

    // Actualizar

    @GetMapping("/buscarUno/{idPersona}")
    public String buscarPersonaId(@PathVariable("idPersona") Integer id, Model modelo ) {
        Persona p = this.personaService.buscarId(id);
        modelo.addAttribute("persona", p);
        return "p_actualizar_id";
    }

    @PutMapping("/actualizar/{idPersona}")
    public String actualizar(@PathVariable("idPersona") Integer id, Persona persona  ) {
        persona.setId(id);
        this.personaService.actualizar(persona);

        return "redirect:/personas/buscar";
    }

    // Eliminar
    @DeleteMapping("/eliminar/{idPersona}")
    public String eliminarId(@PathVariable("idPersona") Integer id) {
        this.personaService.eliminar(id);
        
        return "redirect:/personas/buscar";
    }

    // Insertar
    @GetMapping("/nuevaPersona")
    public String paginaNuevaPersona(Persona persona){
        return "p_insertar";
    }

    @PostMapping("/insertar")
    public String insertar(Persona persona){
        this.personaService.insertar(persona);
        return "redirect:/personas/buscar";
    }


}   
