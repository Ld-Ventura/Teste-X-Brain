package com.teste.xbrain.lucas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.teste.xbrain.lucas.controller.forms.NovoPedidoForm;
import com.teste.xbrain.lucas.models.Pedido;
import com.teste.xbrain.lucas.repository.ClienteRepo;
import com.teste.xbrain.lucas.repository.PedidoRepo;
import com.teste.xbrain.lucas.repository.ProdutoRepo;


@RestController
@RequestMapping("/loja")
public class PedidoController {

	@Autowired
	private ClienteRepo clienteRepo;
	@Autowired
	private ProdutoRepo produtoRepo;
	@Autowired
	private PedidoRepo pedidoRepo;
	
	
	
	@PostMapping()
	public void novoPedido(@RequestBody NovoPedidoForm form, UriComponentsBuilder uri) {
		Pedido pedido = form.toPedido(clienteRepo, produtoRepo);
		pedidoRepo.save(pedido);
	}

}
