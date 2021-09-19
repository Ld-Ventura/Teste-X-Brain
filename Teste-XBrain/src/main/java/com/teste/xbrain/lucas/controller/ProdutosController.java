package com.teste.xbrain.lucas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.xbrain.lucas.controller.forms.NovoProdutoForm;
import com.teste.xbrain.lucas.dto.ProdutoDto;
import com.teste.xbrain.lucas.service.ProdutosService;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
	
	
	@Autowired
	private ProdutosService produtoService ;

	
	@PostMapping("/novoproduto")
	public ResponseEntity<ProdutoDto> novoPedido(@RequestBody @Valid NovoProdutoForm form) {
		ProdutoDto prodDto = produtoService.toProduto(form);
		return ResponseEntity.status(HttpStatus.CREATED).body(prodDto);
	}
	
	@GetMapping()
	public ResponseEntity<?> buscaTodosProdutos(){
		List<ProdutoDto> produtos = produtoService.retornaProdutos();
		return ResponseEntity.status(HttpStatus.OK).body(produtos);
	}
	
}
