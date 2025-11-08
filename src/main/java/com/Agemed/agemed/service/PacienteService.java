package com.Agemed.agemed.service;

import com.Agemed.agemed.model.Paciente;
import com.Agemed.agemed.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    // Salvar/Atualizar
    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    // Listar Todos
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    // Buscar por ID
    public Optional<Paciente> findById(Integer id) {
        return pacienteRepository.findById(id);
    }

    // Deletar
    public void deleteById(Integer id) {
        pacienteRepository.deleteById(id);
    }
}
