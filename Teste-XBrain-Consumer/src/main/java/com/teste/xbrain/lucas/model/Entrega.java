package com.teste.xbrain.lucas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "entregas")
@Data
public class Entrega {

	@Id
	private Long idPedido;

	private String enderecoEntrega;


}
