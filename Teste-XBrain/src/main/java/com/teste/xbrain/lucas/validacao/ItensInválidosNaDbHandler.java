package com.teste.xbrain.lucas.validacao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ItensInválidosNaDbHandler {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NullPointerException.class)
	public ErroDto handle(NullPointerException ex) {
		ErroDto errosDto = new ErroDto("Body", "Itens inválidos no formulário");
		return errosDto;
	}

}
