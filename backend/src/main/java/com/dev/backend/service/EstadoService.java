package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Estado;
import com.dev.backend.repository.EstadoRepository;

@Service
public class EstadoService {

  @Autowired
  private EstadoRepository estadoRepository;
  
  public List<Estado> findAll() {
    return estadoRepository.findAll();
  }

  public Estado insert(Estado estado) {
    estado.setCreationDate(new Date());
    Estado newState = estadoRepository.saveAndFlush(estado);
    return newState;
  }

  public Estado toggle(Estado estado) {
    estado.setUpdateDate(new Date());
    return estadoRepository.saveAndFlush(estado);
  }

  public void delete(Long id) {
    Estado estado = estadoRepository.findById(id).get();
    estadoRepository.delete(estado);
  }
}
