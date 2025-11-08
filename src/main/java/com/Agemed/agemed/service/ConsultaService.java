package com.Agemed.agemed.service;

import com.Agemed.agemed.model.Consulta;
import com.Agemed.agemed.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    //  Salvar/Atualizar
    public Consulta save(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    //  Listar Todos
    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    //  Buscar por ID
    public Optional<Consulta> findById(Integer id) {
        return consultaRepository.findById(id);
    }

    //  Deletar
    public void deleteById(Integer id) {
        consultaRepository.deleteById(id);
    }
}