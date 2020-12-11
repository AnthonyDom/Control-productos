package com.desarrollo.web.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.desarrollo.web.app.models.dao.IVendedorDao;
import com.desarrollo.web.app.models.entity.Vendedor;

@Controller
public class VendedorController {
	@Autowired
	private IVendedorDao vendedorDao;

	@RequestMapping(value = "/listarV", method = RequestMethod.GET)

	public String listar(Model model) {
		model.addAttribute("titulo", "Listado Vendedores");
		model.addAttribute("vendedores", vendedorDao.findAll());
		return "listarV";
	}
	@RequestMapping(value="/formV")
	public String crear(Map<String, Object> model) {
		Vendedor vendedor = new Vendedor();
		model.put("vendedor", vendedor);
		model.put("titulo", "Formulario Registro de Vendedor");
		return "formV";
	}
	
	@RequestMapping(value="/formV", method = RequestMethod.POST)
	public String guardar(Vendedor vendedor) {
		vendedorDao.save(vendedor);
		return "redirect:listarV";
	}

	
}
