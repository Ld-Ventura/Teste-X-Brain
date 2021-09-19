package com.teste.xbrain.lucas.controller.forms;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class NovoProdutoForm {

	@NotNull
	@NotEmpty
	private String nome;
	
	@DecimalMin(value = "0.01", message = "Valor deve ser maior que ZERO")
	@NotNull
	private Double preco;
	
	
	
	
}
