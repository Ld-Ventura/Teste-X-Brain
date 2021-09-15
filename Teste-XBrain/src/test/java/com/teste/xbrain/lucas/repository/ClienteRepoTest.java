package com.teste.xbrain.lucas.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.teste.xbrain.lucas.models.Cliente;

import org.junit.Assert;


@RunWith(SpringRunner.class)
@DataJpaTest
class ClienteRepoTest {

	@Autowired
	private ClienteRepo clienteRepo;
	
	@Test
	void deveDevolverumClientePeloNomeDado() {
		String nomeCliente = "Fulano";
		Cliente clienteEncontrado = clienteRepo.findByNome(nomeCliente);
		Assert.assertNotNull(clienteEncontrado);
		Assert.assertEquals(nomeCliente,clienteEncontrado.getNome());
		
	}

	@Test
	void naoDeveDevolverumClientePeloNomeInválidoNaDB() {
		String nomeCliente = "John";
		Cliente clienteEncontrado = clienteRepo.findByNome(nomeCliente);
		Assert.assertNull(clienteEncontrado);
		
	}
}
