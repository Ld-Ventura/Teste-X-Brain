package com.teste.xbrain.lucas.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@RestControllerAdvice
public class ErrosDeValidacaoHandler {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ NullPointerException.class, JsonParseException.class,
			HttpRequestMethodNotSupportedException.class, InvalidFormatException.class })
	public ErroDto handle() {
		ErroDto errosDto = new ErroDto("Body", "Itens inválidos no formulário");
		return errosDto;
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDto> handle(MethodArgumentNotValidException ex) {
		List<ErroDto> errosDto = new ArrayList<>();
		List<FieldError> errors = ex.getBindingResult().getFieldErrors();
		errors.forEach(erro -> {
			errosDto.add(new ErroDto(erro.getField(), erro.getDefaultMessage()));
		});
		return errosDto;

	}

}
