package com.dev.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entity.Estado;
import com.dev.backend.service.EstadoService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

  @Autowired
  private EstadoService estadoService;

  @GetMapping("/")
  public List<Estado> findAll() {
    return estadoService.findAll();
  }

  @PostMapping("/")
  public Estado insert(@RequestBody Estado estado) {
    return estadoService.insert(estado);
  }

  @PutMapping("/")
  public Estado toggle(@RequestBody Estado estado) {
    return estadoService.toggle(estado);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    estadoService.delete(id);
    return ResponseEntity.ok().build();
  }
}
