package com.teste.xbrain.lucas.validacao;

import lombok.Getter;

@Getter
public class ErroDto {

	private String campo;
	private String erro;

	
	public ErroDto(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}
	
}
