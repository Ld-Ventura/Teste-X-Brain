package com.teste.xbrain.lucas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.xbrain.lucas.models.Produto;

public interface ProdutoRepo extends JpaRepository<Produto, Long>{

	Produto findByNome(String produto);

}
