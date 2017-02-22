package com.market.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.market.model.Empresa;
import com.market.model.Produto;
import com.market.negocio.IEmpresa;
import com.market.negocio.IProduto;
import com.market.negocio.ITipoEmpresa;
import com.market.negocio.service.CadastroEmpresaService;
import com.market.negocio.service.CadastroProdutoService;

@Controller
public class EmpresaController {
	public Collection<Empresa> listaEmpresas;
	
	@Autowired
	private IEmpresa empresas;
	@Autowired
	private IProduto produtos;	
	@Autowired
	private ITipoEmpresa listaTipoEmpresa;
	@Autowired
	private CadastroEmpresaService cadastroEmpresa;
	@Autowired
	private CadastroProdutoService cadastroProduto;
	
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
	@RequestMapping("/empresa/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Integer codigo, Produto produto){
		 ModelAndView mv = new ModelAndView("empresa");
		 mv.addObject("empresa",empresas.findOne(codigo));
		 //mv.addObject("produtos",produtos.);
		 mv.addObject("listaTipoEmpresa",listaTipoEmpresa.findAll());
		 mv.addObject("produtos",produtos.findByIdEmpresa(codigo));
		 return mv;
	}
	@RequestMapping("/empresas/remover/{codigo}")
	public ModelAndView remover(@PathVariable("codigo") Integer codigo){
		this.cadastroEmpresa.excluirEmpresa(empresas.findOne(codigo));
		return new ModelAndView("redirect:/empresas");
	}
	
	@RequestMapping(value= "/empresa/{codigo}", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Produto produto,@PathVariable("codigo") Integer codigo){
		Empresa empresa = empresas.getOne(codigo);
		produto.setEmpresa(empresa);
		this.cadastroProduto.salvarProduto(produto);
		return new ModelAndView("redirect:/empresa/{codigo}");
	}
}
