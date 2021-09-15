package com.teste.xbrain.lucas.dto;

import com.teste.xbrain.lucas.models.Pedido;

public class PedidoDto {

	private Long id;
	private String endereco;

	
	
	
	
	public PedidoDto() {
	}

	public PedidoDto(Pedido pedido) {
		this.setId(pedido.getId());
		this.setEndereco(pedido.getEderecoDaEntrega());

	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
