package com.market.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.market.model.Empresa;
import com.market.negocio.IEmpresa;

@Controller
public class EmpresaController {
	public Collection<Empresa> listaEmpresas;
	
	@Autowired
	private IEmpresa empresas;
	
	@RequestMapping("/empresas")
	public ModelAndView  listar(){
		return new ModelAndView("listaEmpresas").addObject("empresas",empresas.findAll());
	}
}
