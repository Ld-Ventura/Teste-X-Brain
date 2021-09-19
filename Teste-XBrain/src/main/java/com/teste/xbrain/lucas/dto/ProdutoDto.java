package com.teste.xbrain.lucas.dto;

import com.teste.xbrain.lucas.models.Produto;

import lombok.Getter;

@Getter
public class ProdutoDto {

	private Long id;
	private String nome;
	private Double preco;

	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
	}


}
