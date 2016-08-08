package com.market.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.market.model.Empresa;

@Controller
public class EmpresaController {
	public Collection<Empresa> listaEmpresas;
	
	@RequestMapping("/empresas")
	public ModelAndView  listar(){
		listaEmpresas = new ArrayList<Empresa>();
		listaEmpresas.add(new Empresa("Lojas Americanas","33.014.556/0001-96",1,"Rua Grande, São Luis-MA"));
		listaEmpresas.add(new Empresa("Hiper Bom Preço","13.004.510/0001-89",1,"Renascença, São Luis-MA"));	
		listaEmpresas.add(new Empresa("Walmart","14.314.050/0001-58",1,"Renascença, São Luis-MA"));	
		return new ModelAndView("listaEmpresas").addObject("empresas",listaEmpresas);
		
		
	}
}
