package com.teste.xbrain.lucas.controller;

import javax.validation.Valid;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.xbrain.lucas.connectionConfig.RabbitConstants;
import com.teste.xbrain.lucas.controller.forms.NovoPedidoForm;
import com.teste.xbrain.lucas.dto.PedidoDto;
import com.teste.xbrain.lucas.models.Pedido;
import com.teste.xbrain.lucas.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private RabbitTemplate template;
	@Autowired
	private PedidoService pedidoService; 
	
	@PostMapping("/novopedido")
	public ResponseEntity<NovoPedidoForm> novoPedido(@RequestBody @Valid NovoPedidoForm form) {
		Pedido pedido = pedidoService.toPedido(form);
		template.convertAndSend(RabbitConstants.EXCHANGE, RabbitConstants.ROUTING_KEY, new PedidoDto(pedido));
		return ResponseEntity.status(HttpStatus.CREATED).body(form);
	}
	
}
