package com.cefet.ds_guia12.controllers;

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

import com.cefet.ds_guia12.dto.FuncionarioDTO;
import com.cefet.ds_guia12.services.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;
    
    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> findById(@PathVariable Long id) {
    	FuncionarioDTO funcionarioDTO = funcionarioService.findById(id);
        return ResponseEntity.ok(funcionarioDTO);
    }
    
    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> findAll() {
        List<FuncionarioDTO> funcionariosDTOs = funcionarioService.findAll();
        return ResponseEntity.ok(funcionariosDTOs);
    }
    
    @PostMapping
    public ResponseEntity<FuncionarioDTO> create(@RequestBody FuncionarioDTO funcionarioDTO) {
    	FuncionarioDTO novoFuncionario = funcionarioService.insert(funcionarioDTO);
        return ResponseEntity.status(201).body(novoFuncionario);
    }    
    
    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> update(@PathVariable Long id, @RequestBody FuncionarioDTO funcionarioDTO) {
    	FuncionarioDTO produtoAtualizado = funcionarioService.update(id, funcionarioDTO);
        return ResponseEntity.ok(produtoAtualizado);
    }    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
    	funcionarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Boolean> existsByCpf(@PathVariable String cpf) {
        boolean exists = funcionarioService.existsByCpf(cpf);
        return ResponseEntity.ok(exists);
    }    
}
