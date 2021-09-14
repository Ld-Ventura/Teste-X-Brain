package com.teste.xbrain.lucas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.xbrain.lucas.models.Cliente;


public interface ClienteRepo extends JpaRepository<Cliente, Long>{

	
	Cliente findByNome(String cliente);

}
