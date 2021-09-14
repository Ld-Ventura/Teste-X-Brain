package com.teste.xbrain.lucas.controller.forms;

import java.util.List;

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
		Double precoTotal = 0.0;
		pedido.setCliente(clienteRepo.findByNome(cliente));
		for (String produto : produtos) {
			Produto produtofindByNome = produtoRepo.findByNome(produto);
			pedido.add(produtofindByNome);
			precoTotal += produtofindByNome.getPreco();
		}
		pedido.setPrecoTotal(precoTotal);
		return pedido;
           

	}

}
