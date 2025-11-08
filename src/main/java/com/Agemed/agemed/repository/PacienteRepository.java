package com.Agemed.agemed.repository;

import com.Agemed.agemed.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}
