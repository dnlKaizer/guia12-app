package com.cefet.ds_guia12.dto;

import com.cefet.ds_guia12.entities.Funcionario;

public class FuncionarioDTO {
	private Long id;
	private String nome;   
	private String cpf;
	private String rua;
	private String numero;
	private String cidade;
	private String estado;
	
	public FuncionarioDTO() {
	}	
	
	public FuncionarioDTO(Funcionario funcionario) {
		this.id = funcionario.getId();
		this.nome = funcionario.getNome();
		this.cpf = funcionario.getCpf();
		this.rua = funcionario.getRua();
		this.numero = funcionario.getNumero();
		this.cidade = funcionario.getCidade();
		this.estado = funcionario.getEstado();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getRua() {
		return rua;
	}

	public String getNumero() {
		return numero;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}
}
