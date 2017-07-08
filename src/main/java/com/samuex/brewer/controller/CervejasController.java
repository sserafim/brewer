package com.samuex.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.samuex.brewer.model.Cerveja;

@Controller
public class CervejasController {

	@RequestMapping("/cervejas/novo")  //mapea url para acessar página html CadastroCerveja.html
	public String novo(Cerveja cerveja) {	
		return "cerveja/CadastroCerveja";
	}

	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST) // RequestMapping para o method POST
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) { 
			return novo(cerveja);
		}

		// Salvar no banco de dados...
		
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!"); // Mantem sessão request para exibir mensagem de sucesso
		System.out.println(">>>> sku: " + cerveja.getSku());	
		return "redirect:/cervejas/novo";
	}
	
	
}