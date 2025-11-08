package com.Agemed.agemed.controller;

import com.Agemed.agemed.model.Paciente;
import com.Agemed.agemed.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;


    // LISTAR
    @GetMapping
    public String listarPacientes(Model model) {
        model.addAttribute("pacientes", pacienteService.findAll());
        return "pacientes/listar"; // view: /templates/pacientes/listar.html
    }

    // CADASTRAR (Exibir formulário)
    @GetMapping("/cadastrar")
    public String exibirFormulario(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "pacientes/cadastrar"; // view: /templates/pacientes/cadastrar.html
    }

    // CADASTRAR/EDITAR (Salvar)
    @PostMapping("/salvar")
    public String salvarPaciente(@ModelAttribute Paciente paciente) {
        pacienteService.save(paciente);
        return "redirect:/pacientes";
    }

    // EDITAR (Exibir formulário preenchido)
    @GetMapping("/editar/{id}")
    public String editarPaciente(@PathVariable Integer id, Model model) {
        Optional<Paciente> paciente = pacienteService.findById(id);
        if (paciente.isPresent()) {
            model.addAttribute("paciente", paciente.get());
            return "pacientes/cadastrar"; // Reutiliza o template de cadastro
        }
        return "redirect:/pacientes";
    }

    // EXCLUIR
    @GetMapping("/excluir/{id}")
    public String excluirPaciente(@PathVariable Integer id) {
        pacienteService.deleteById(id);
        return "redirect:/pacientes";
    }


}
