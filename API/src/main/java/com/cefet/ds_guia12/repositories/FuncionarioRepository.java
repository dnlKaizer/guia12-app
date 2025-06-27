package com.cefet.ds_guia12.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.ds_guia12.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	boolean existsByCpf(String cpf);
}
