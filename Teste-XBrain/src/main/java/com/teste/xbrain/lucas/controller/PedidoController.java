package com.teste.xbrain.lucas.controller;

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
import com.teste.xbrain.lucas.repository.ClienteRepo;
import com.teste.xbrain.lucas.repository.PedidoRepo;
import com.teste.xbrain.lucas.repository.ProdutoRepo;

@RestController
@RequestMapping("/loja")
public class PedidoController {

	@Autowired
	private PedidoRepo pedidoRepo;
	@Autowired
	private ClienteRepo clienteRepo;
	@Autowired
	private ProdutoRepo produtoRepo;
	@Autowired
	private RabbitTemplate template;

	@PostMapping("/novopedido")
	public ResponseEntity<NovoPedidoForm> novoPedido(@RequestBody NovoPedidoForm form) {
		
		Pedido pedido = form.toPedido(clienteRepo, produtoRepo);
		pedidoRepo.save(pedido);
		template.convertAndSend(RabbitConstants.EXCHANGE, RabbitConstants.ROUTING_KEY, new PedidoDto(pedido));
		return ResponseEntity.status(HttpStatus.CREATED).body(form);
	}
	
}
