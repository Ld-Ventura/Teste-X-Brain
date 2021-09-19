package com.teste.xbrain.lucas.controller;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProdutoControllerTest {

	@Autowired
	private MockMvc mockMvc;
	

	@Test
	public void deveDevolver201CriandoNovoProduto() throws Exception {
		
		URI uri = new URI("/produtos/novoproduto");
		String json = "{ \"nome\"  :  \"Tal\"  , \"preco\": 500.00}";

		mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(201));
		
	}
	@Test
	public void deveDevolver400PoisOPrecoDeveSerMaiorQueZero() throws Exception {
		
		URI uri = new URI("/produtos/novoproduto");
		String json = "{ \"nome\"  :  \"Tal\"  , \"preco\": 0}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(400));
		
	}
	@Test
	public void deveDevolver400PoisNenhumCampoDeveSerNullOuVazio() throws Exception {
		
		URI uri = new URI("/produtos/novoproduto");
		String json = "{ \"nome\"  :  \"\"  , \"preco\": null }";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(400));
		
	}
	
	
}
