package com.Agemed.agemed.dto;

import com.Agemed.agemed.model.Medico;
import lombok.Data;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class AgendaCompletaDTO {

    private String nomeMedico;
    private String especialidade;
    private List<ConsultaDTO> consultas;

    public AgendaCompletaDTO(Medico medico) {
        this.nomeMedico = medico.getNome();
        this.especialidade = medico.getEspecialidade();
        // Mapeia a lista de Consultas para a lista de ConsultaDTO
        this.consultas = medico.getConsultas().stream()
                .map(ConsultaDTO::new)
                .collect(Collectors.toList());
    }
}