package com.teste.xbrain.lucas.controller.forms;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class NovoPedidoForm {

	@NotNull
	@NotEmpty
	private String cliente;
	@NotNull
	@NotEmpty
	private List<String> produtos;

	

}
