package com.market.negocio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.model.Empresa;

public interface IEmpresa extends JpaRepository<Empresa, Long>{

}
