package com.teste.xbrain.lucas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.xbrain.lucas.controller.forms.NovoClienteForm;
import com.teste.xbrain.lucas.dto.ClienteDto;
import com.teste.xbrain.lucas.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	
	@Autowired
	private ClienteService clienteService;

	
	@PostMapping("/novocliente")
	public ResponseEntity<ClienteDto> novoCliente(@RequestBody @Valid NovoClienteForm form) {
		ClienteDto cliente = clienteService.toCliente(form);
		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	}
	
	@GetMapping()
	public ResponseEntity<List<ClienteDto>> buscaTodosClientes(){
		List<ClienteDto> clientes = clienteService.retornaClientes();
		return ResponseEntity.status(HttpStatus.OK).body(clientes);
	}
	
}
