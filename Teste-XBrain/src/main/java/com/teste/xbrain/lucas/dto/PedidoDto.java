package com.teste.xbrain.lucas.dto;

import com.teste.xbrain.lucas.models.Pedido;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PedidoDto {

	private Long id;
	private String endereco;

	public PedidoDto(Pedido pedido) {
		this.id = pedido.getId();
		this.endereco = pedido.getEderecoDaEntrega();

	}

}
