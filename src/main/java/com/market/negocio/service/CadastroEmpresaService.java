package com.market.negocio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayway.jsonpath.internal.Utils;
import com.market.model.Empresa;
import com.market.negocio.IEmpresa;

@Service
public class CadastroEmpresaService {
	@Autowired
	private IEmpresa empresas;

	public void salvarEmpresa(Empresa empresa) {
			empresas.save(empresa);
	}
	
	public void excluirEmpresa(Empresa empresa){
		empresas.delete(empresa);		
	}

}
