package com.teste.xbrain.lucas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.teste.xbrain.lucas.dto.PedidoDto;

@Entity
@Table(name = "entregas")
public class Entrega {

	@Id
	private Long idPedido;

	private String enderecoEntrega;

	public Long getIdPedido() {
		return idPedido;
	}

	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public Entrega() {
	}

	public Entrega(PedidoDto pedido) {
		this.idPedido = pedido.getId();
		this.enderecoEntrega = pedido.getEndereco();
	}

	@Override
	public String toString() {
		return "Entrega [idPedido= " + idPedido + ", enderecoEntrega= " + enderecoEntrega + "]";
	}

}
