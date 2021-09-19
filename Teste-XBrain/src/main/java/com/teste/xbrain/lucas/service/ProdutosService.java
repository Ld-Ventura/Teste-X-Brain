package com.teste.xbrain.lucas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.xbrain.lucas.controller.forms.NovoProdutoForm;
import com.teste.xbrain.lucas.dto.ProdutoDto;
import com.teste.xbrain.lucas.models.Produto;
import com.teste.xbrain.lucas.repository.ProdutoRepo;

@Service
public class ProdutosService {

	@Autowired
	private ProdutoRepo produtoRepo;
	
	public ProdutoDto toProduto(NovoProdutoForm form) {
		Produto produto = new Produto();
		produto.setNome(form.getNome());
		produto.setPreco(form.getPreco());
		produtoRepo.save(produto);
		return new ProdutoDto(produto);
	}

		public List<ProdutoDto> retornaProdutos(){
		List<ProdutoDto> listaProdDtos = new ArrayList<>();
		List<Produto> produtos = produtoRepo.findAll();
		produtos.forEach(cliente -> listaProdDtos.add(new ProdutoDto(cliente)));
		return listaProdDtos;
	}

	
	
	
}
