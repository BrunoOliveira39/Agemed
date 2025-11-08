package com.Agemed.agemed.controller;

import com.Agemed.agemed.model.Medico;
import com.Agemed.agemed.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    // LISTAR: Exibe a lista de médicos
    @GetMapping
    public String listarMedicos(Model model) {
        model.addAttribute("medicos", medicoService.findAll());
        return "medicos/listar"; // view: /templates/medicos/listar.html
    }

    // CADASTRAR: Exibe o formulário de cadastro
    @GetMapping("/cadastrar")
    public String exibirFormulario(Model model) {
        model.addAttribute("medico", new Medico());
        return "medicos/cadastrar"; // view: /templates/medicos/cadastrar.html
    }

    // CADASTRAR/EDITAR: Processa o envio do formulário
    @PostMapping("/salvar")
    public String salvarMedico(@ModelAttribute Medico medico) {
        medicoService.save(medico);
        return "redirect:/medicos";
    }

    // EDITAR: Exibe o formulário preenchido para edição
    @GetMapping("/editar/{id}")
    public String editarMedico(@PathVariable Integer id, Model model) {
        Optional<Medico> medico = medicoService.findById(id);
        if (medico.isPresent()) {
            model.addAttribute("medico", medico.get());
            return "medicos/cadastrar"; // Reutiliza o template de cadastro
        }
        return "redirect:/medicos"; // Se não encontrar, volta para a lista
    }

    // EXCLUIR
    @GetMapping("/excluir/{id}")
    public String excluirMedico(@PathVariable Integer id) {
        medicoService.deleteById(id);
        return "redirect:/medicos";
    }
}
