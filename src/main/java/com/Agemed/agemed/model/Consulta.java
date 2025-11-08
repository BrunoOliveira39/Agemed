package com.Agemed.agemed.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime; // NOVO IMPORT

@Entity
@Data
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private LocalDateTime dataConsulta;

    private String paciente;

    private String observacoes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;
}