package com.teste.xbrain.lucas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.xbrain.lucas.controller.forms.NovoClienteForm;
import com.teste.xbrain.lucas.dto.ClienteDto;
import com.teste.xbrain.lucas.models.Cliente;
import com.teste.xbrain.lucas.repository.ClienteRepo;

@Service
public class ClienteService {

	

	@Autowired
	private ClienteRepo clienteRepo;

	public ClienteDto toCliente(NovoClienteForm form) {

		Cliente cliente = new Cliente();
		cliente.setNome(form.getNome());
		cliente.setEndereco(form.getEndereco());
		clienteRepo.save(cliente);
		return new ClienteDto(cliente);
	}

	public List<ClienteDto> retornaClientes(){
		List<ClienteDto> listaClientesDtos = new ArrayList<>();
		List<Cliente> clientes = clienteRepo.findAll();
		clientes.forEach(cliente -> listaClientesDtos.add(new ClienteDto(cliente)));
		return listaClientesDtos;
	}
	
	
}
