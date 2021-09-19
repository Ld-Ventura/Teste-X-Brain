package com.teste.xbrain.lucas.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.teste.xbrain.lucas.connectionConfig.RabbitConstants;
import com.teste.xbrain.lucas.dto.PedidoDto;
import com.teste.xbrain.lucas.service.EntregaService;

@Component
public class Consumer {


	
	@Autowired
	private EntregaService entregaService;
	
	
	@RabbitListener(queues = RabbitConstants.QUEUE)
	public void consumeMessage(PedidoDto pedido) {
		entregaService.toEntrega(pedido);
		System.out.println("Pedido de entrega recebido:\n " + pedido);
	}
}
