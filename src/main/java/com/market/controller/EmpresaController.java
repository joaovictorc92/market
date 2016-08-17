package com.market.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.market.model.Empresa;
import com.market.negocio.IEmpresa;
import com.market.negocio.ITipoEmpresa;
import com.market.negocio.service.CadastroEmpresaService;

@Controller
public class EmpresaController {
	public Collection<Empresa> listaEmpresas;
	
	@Autowired
	private IEmpresa empresas;
	@Autowired
	private ITipoEmpresa listaTipoEmpresa;
	@Autowired
	private CadastroEmpresaService cadastroEmpresa;
	
	@RequestMapping("/empresas")
	public ModelAndView  listar(Empresa empresa){
		 ModelAndView mv = new ModelAndView("listaEmpresas").addObject("empresas",empresas.findAll());
		 mv.addObject("listaTipoEmpresa",listaTipoEmpresa.findAll());
		 return mv;
	}
	
	@RequestMapping(value= "/empresas", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Empresa empresa){
		this.cadastroEmpresa.salvarEmpresa(empresa);
		return new ModelAndView("redirect:/empresas");
	}
	@RequestMapping("/empresas/{codigo}")
	public ModelAndView editar(@Valid Empresa empresa){
		 ModelAndView mv = new ModelAndView("listaEmpresas");
		 mv.addObject("empresa",empresa);
		 mv.addObject("empresas",empresas.findAll());
		 mv.addObject("listaTipoEmpresa",listaTipoEmpresa.findAll());
		 return mv;
	}
}
