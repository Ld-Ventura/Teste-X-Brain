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
		addProdutos(produtoRepo, pedido);
		pedido.setValorTotal(somaValorTotal(produtoRepo));

		return pedido;

	}

	private void addProdutos(ProdutoRepo produtoRepo, Pedido pedido) {
		for (String prod : produtos) {
			Produto produtoFind = produtoRepo.findByNome(prod);
			pedido.add(produtoFind);
		}
	}

	private Double somaValorTotal(ProdutoRepo produtoRepo) {
		Double valorTotal = .0;
		for (String produto : produtos) {
			valorTotal += produtoRepo.findByNome(produto).getPreco();
		}
		return valorTotal;
	}

}
