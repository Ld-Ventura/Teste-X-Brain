package com.teste.xbrain.lucas.controller.forms;

import java.util.List;

import com.teste.xbrain.lucas.models.Cliente;
import com.teste.xbrain.lucas.models.Pedido;
import com.teste.xbrain.lucas.models.Produto;
import com.teste.xbrain.lucas.repository.ClienteRepo;
import com.teste.xbrain.lucas.repository.ProdutoRepo;

public class NovoPedidoForm {

	private String cliente;
	private List<String> produtos;

	public String getCliente() {
		return cliente;
	}

	public List<String> getProdutos() {
		return produtos;
	}

	public Pedido toPedido(ClienteRepo clienteRepo, ProdutoRepo produtoRepo) {
		Pedido pedido = new Pedido();
		Cliente clinteByNone = clienteRepo.findByNome(cliente);
		
		pedido.setCliente(clinteByNone);
		pedido.setEderecoDaEntrega(clinteByNone.getEndereco());
		
		
		Double valorTotal = .0;
		for (String produto : produtos) {
			Produto produtofindByNome = produtoRepo.findByNome(produto);
			pedido.add(produtofindByNome);
			valorTotal += produtofindByNome.getPreco();
		}
		
		pedido.setValorTotal(valorTotal);
		return pedido;

	}
	



}
