package com.market.negocio.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.model.Produto;
import com.market.negocio.IProduto;

@Service
public class CadastroProdutoService {
	@Autowired
	private IProduto produtos;
	
	public void salvarProduto(Produto produto){
		produtos.save(produto);
	}
	
	public void deletarProduto(Produto produto){
		produtos.delete(produto);
	}
}
