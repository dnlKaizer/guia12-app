package com.cefet.ds_guia12.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.ds_guia12.dto.FuncionarioDTO;
import com.cefet.ds_guia12.entities.Funcionario;
import com.cefet.ds_guia12.repositories.FuncionarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	// Buscar todos
	public List<FuncionarioDTO> findAll() {
		List<Funcionario> listaFuncionario = funcionarioRepository.findAll();
		return listaFuncionario.stream().map(FuncionarioDTO::new).toList();
	}	
	
	// Buscar por ID
    public FuncionarioDTO findById(Long id) {
    	Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com ID: " + id));
        return new FuncionarioDTO(funcionario);       
    }	
    
    // Inserir 
    public FuncionarioDTO insert(FuncionarioDTO funcionarioDTO) {
    	Funcionario funcionario = new Funcionario();
    	funcionario.setNome(funcionarioDTO.getNome());
    	funcionario.setCpf(funcionarioDTO.getCpf());
    	funcionario.setRua(funcionarioDTO.getRua());
    	funcionario.setNumero(funcionarioDTO.getNumero());
    	funcionario.setCidade(funcionarioDTO.getCidade());
    	funcionario.setEstado(funcionarioDTO.getEstado());
    	Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);
        return new FuncionarioDTO(funcionarioSalvo);
    }    
    
    // Atualizar  
    public FuncionarioDTO update(Long id, FuncionarioDTO funcionarioDTO) {
    	Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com ID: " + id));
       	funcionario.setNome(funcionarioDTO.getNome());
    	funcionario.setCpf(funcionarioDTO.getCpf());
    	funcionario.setRua(funcionarioDTO.getRua());
    	funcionario.setNumero(funcionarioDTO.getNumero());
    	funcionario.setCidade(funcionarioDTO.getCidade());
    	funcionario.setEstado(funcionarioDTO.getEstado());       
    	Funcionario funcionarioAtualizado = funcionarioRepository.save(funcionario);
        return new FuncionarioDTO(funcionarioAtualizado);
    }    
	
    // Remover por ID
    public void delete(Long id) {
        if (!funcionarioRepository.existsById(id)) {
            throw new EntityNotFoundException("Funcionário não encontrado com ID: " + id);
        }
        funcionarioRepository.deleteById(id);       
    }  
    
    // Verificar CPF
    public boolean existsByCpf(String cpf) {
        return funcionarioRepository.existsByCpf(cpf);
    }
	
}
