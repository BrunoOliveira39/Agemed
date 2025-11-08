package com.Agemed.agemed.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String especialidade;

    // Relacionamento OneToMany: Um médico pode ter várias consultas
    // Mapeado por "medico" na classe Consulta
    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Consulta> consultas;
}