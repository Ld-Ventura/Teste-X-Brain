package com.teste.xbrain.lucas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.xbrain.lucas.controller.forms.NovoPedidoForm;
import com.teste.xbrain.lucas.models.Cliente;
import com.teste.xbrain.lucas.models.Pedido;
import com.teste.xbrain.lucas.models.Produto;
import com.teste.xbrain.lucas.repository.ClienteRepo;
import com.teste.xbrain.lucas.repository.PedidoRepo;
import com.teste.xbrain.lucas.repository.ProdutoRepo;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepo pedidoRepo;
	@Autowired
	private ClienteRepo clienteRepo;
	@Autowired
	private ProdutoRepo produtoRepo;

	public Pedido toPedido(NovoPedidoForm form) {
		Pedido pedido = new Pedido();

		Cliente clinteByNone = clienteRepo.findByNome(form.getCliente());
		pedido.setCliente(clinteByNone);
		pedido.setEderecoDaEntrega(clinteByNone.getEndereco());
		addProdutos(form.getProdutos(), pedido);
		pedido.setValorTotal(somaValorTotal(form));
		return pedidoRepo.save(pedido);

	}

	private void addProdutos(List<String> produtos, Pedido pedido) {
		for (String prod : produtos) {
			Produto produtoFind = produtoRepo.findByNome(prod);
			pedido.getProdutos().add(produtoFind);
		}
	}

	private Double somaValorTotal(NovoPedidoForm form) {
		Double valorTotal = .0;
		for (String produto : form.getProdutos()) {
			valorTotal += produtoRepo.findByNome(produto).getPreco();
		}
		return valorTotal;
	}
	
}
