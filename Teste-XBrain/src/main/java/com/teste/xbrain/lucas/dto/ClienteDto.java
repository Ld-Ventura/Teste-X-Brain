package com.teste.xbrain.lucas.dto;

import com.teste.xbrain.lucas.models.Cliente;

import lombok.Getter;

@Getter
public class ClienteDto {

	private Long id;
	private String nome;
	private String endereco;
	
	
	public ClienteDto(Cliente cliente) {
		super();
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.endereco = cliente.getEndereco();
	}

	
}
