package com.market.negocio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.model.TipoEmpresa;

public interface ITipoEmpresa extends JpaRepository<TipoEmpresa, Long> {

}
