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
class PedidoControllerTest {

	@Autowired
	private MockMvc mockMvc;
	

	@Test
	public void deveDevolver201CriandoNovoPedido() throws Exception {
		
		URI uri = new URI("/loja/novopedido");
		String json = "{\"cliente\":\"Ciclano\", \"produtos\":[\"Televisao\",\"Celular\",\"Note-book\"]}";
		
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
	public void deveDevolver404CriandoNovoPedidoPorItensSeremInválidosNaDb() throws Exception {
		
		URI uri = new URI("/loja/novopedido");
		String json = "{\"cliente\":\"John\", \"produtos\":[\"Carro\",\"Moto\",\"Pneu\"]}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.isBadRequest());
		
	}
	
}
