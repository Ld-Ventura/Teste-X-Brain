package com.teste.xbrain.lucas.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.teste.xbrain.lucas.models.Produto;




@RunWith(SpringRunner.class)
@DataJpaTest
class ProdutoRepoTest {

	@Autowired
	private ProdutoRepo produtoRepo;
	
	@Test
	void deveDevolverumProdutoPeloNomeDado() {
		String nomeProduto = "Televisao";
		Produto prodEncontrado = produtoRepo.findByNome(nomeProduto);
		Assert.assertNotNull(prodEncontrado);
		Assert.assertEquals(nomeProduto,prodEncontrado.getNome());
		
	}

	@Test
	void naoDeveDevolverumProdutoPeloNomeInválidoNaDB() {
		String nomeProduto = "Bola";
		Produto prodEncontrado = produtoRepo.findByNome(nomeProduto);
		Assert.assertNull(prodEncontrado);
		
	}

}
