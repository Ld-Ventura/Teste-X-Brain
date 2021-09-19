package com.teste.xbrain.lucas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.xbrain.lucas.dto.PedidoDto;
import com.teste.xbrain.lucas.model.Entrega;
import com.teste.xbrain.lucas.repository.EntregaRepo;

@Service
public class EntregaService {

	@Autowired
	private EntregaRepo entregaRepo;
	
	public void toEntrega(PedidoDto pedido) {
		Entrega entrega = new Entrega();
		entrega.setIdPedido(pedido.getId());
		entrega.setEnderecoEntrega(pedido.getEndereco());
		entregaRepo.save(entrega);
	}

}
