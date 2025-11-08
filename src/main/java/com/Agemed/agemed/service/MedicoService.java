package com.Agemed.agemed.service;

import com.Agemed.agemed.model.Medico;
import com.Agemed.agemed.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    //  Salvar/Atualizar
    public Medico save(Medico medico) {
        return medicoRepository.save(medico);
    }

    //  Listar Todos
    public List<Medico> findAll() {
        // Retorna todos os médicos. O relacionamento @OneToMany com Consulta é carregado
        // lazy, mas será acessado nos DTOs ou Controllers que precisarem dos dados.
        return medicoRepository.findAll();
    }

    //  Buscar por ID
    public Optional<Medico> findById(Integer id) {
        return medicoRepository.findById(id);
    }

    //  Deletar
    public void deleteById(Integer id) {
        medicoRepository.deleteById(id);
    }
}