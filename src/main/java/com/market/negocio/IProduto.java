package com.market.negocio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.market.model.Produto;

public interface IProduto extends JpaRepository<Produto, Integer> {
	@Query("select p from Produto p where p.empresa.idempresa = ?1")
	Collection<Produto> findByIdEmpresa(@Param("idempresa") Integer idempresa);
}
