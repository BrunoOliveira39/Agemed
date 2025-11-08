package com.Agemed.agemed.dto;

import com.Agemed.agemed.model.Consulta;
import lombok.Data;
import java.time.LocalDateTime; // NOVO IMPORT

@Data
public class ConsultaDTO {

    private LocalDateTime dataConsulta;
    private String paciente;
    private String observacoes;

    public ConsultaDTO(Consulta consulta) {
        this.dataConsulta = consulta.getDataConsulta();
        this.paciente = consulta.getPaciente().getNome();
        this.observacoes = consulta.getObservacoes();
    }
}