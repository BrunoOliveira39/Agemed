package com.Agemed.agemed.controller;

import com.Agemed.agemed.dto.AgendaCompletaDTO;
import com.Agemed.agemed.model.Medico;
import com.Agemed.agemed.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

// Este é um REST Controller, o retorno é JSON ou XML
@RestController
@RequestMapping("/api/agenda")
public class AgendaRestController {

    @Autowired
    private MedicoService medicoService;

    // ENDPOINT DE AGENDA COMPLETA
    @GetMapping
    public List<AgendaCompletaDTO> getAgendaCompleta() {
        // Busca todos os médicos (as consultas virão junto devido ao DTO acessá-las)
        List<Medico> medicos = medicoService.findAll();

        // Mapeia a lista de Médicos para o DTO de Agenda Completa
        return medicos.stream()
                .map(AgendaCompletaDTO::new)
                .collect(Collectors.toList());
    }
}
