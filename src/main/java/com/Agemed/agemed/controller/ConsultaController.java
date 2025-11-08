package com.Agemed.agemed.controller;

import com.Agemed.agemed.model.Consulta;
import com.Agemed.agemed.service.ConsultaService;
import com.Agemed.agemed.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @Autowired
    private MedicoService medicoService; // Necessário para listar os médicos no formulário

    // LISTAR: Exibe a lista de consultas
    @GetMapping
    public String listarConsultas(Model model) {
        model.addAttribute("consultas", consultaService.findAll());
        return "consultas/listar"; // view: /templates/consultas/listar.html
    }

    // CADASTRAR: Exibe o formulário de cadastro
    @GetMapping("/cadastrar")
    public String exibirFormulario(Model model) {
        model.addAttribute("consulta", new Consulta());
        model.addAttribute("medicos", medicoService.findAll()); // Passa a lista de médicos
        return "consultas/cadastrar"; // view: /templates/consultas/cadastrar.html
    }

    // CADASTRAR/EDITAR: Processa o envio do formulário
    @PostMapping("/salvar")
    public String salvarConsulta(@ModelAttribute Consulta consulta) {
        consultaService.save(consulta);
        return "redirect:/consultas";
    }

    // EDITAR: Exibe o formulário preenchido para edição
    @GetMapping("/editar/{id}")
    public String editarConsulta(@PathVariable Integer id, Model model) {
        Optional<Consulta> consulta = consultaService.findById(id);
        if (consulta.isPresent()) {
            model.addAttribute("consulta", consulta.get());
            model.addAttribute("medicos", medicoService.findAll()); // Passa a lista de médicos
            return "consultas/cadastrar"; // Reutiliza o template de cadastro
        }
        return "redirect:/consultas";
    }

    // EXCLUIR
    @GetMapping("/excluir/{id}")
    public String excluirConsulta(@PathVariable Integer id) {
        consultaService.deleteById(id);
        return "redirect:/consultas";
    }
}