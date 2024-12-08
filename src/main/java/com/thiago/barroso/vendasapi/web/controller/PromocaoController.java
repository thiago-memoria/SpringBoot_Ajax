package com.thiago.barroso.vendasapi.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thiago.barroso.vendasapi.domain.Categoria;
import com.thiago.barroso.vendasapi.repository.CategoriaRepository;

@Controller
@RequestMapping("/promocao")
public class PromocaoController {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@ModelAttribute("categorias")
	public List<Categoria> getCategorias(){
		return categoriaRepository.findAll();
	}
	
	@GetMapping("/add")
	public String abrirCadastro() {
		return "promo-add";
	}
	
}
