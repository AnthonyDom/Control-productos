package com.desarrollo.web.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.desarrollo.web.app.models.entity.Producto;
import com.desarrollo.web.app.models.service.IProductoService;


@Controller
public class ProductoController {
@Autowired
private IProductoService productoService;

@RequestMapping(value = {"/listarP", "/"}, method = RequestMethod.GET)

public String listar(Model model) {
	model.addAttribute("titulo","Listado de Productos");
	model.addAttribute("productos", productoService.findAll());
	return "listarP";
}

@RequestMapping(value="/formP")
public String crear(Map<String, Object> model) {
	Producto producto = new Producto();
	model.put("producto", producto);
	model.put("titulo", "Formulario Registro de producto");
	return "formP";
}
@RequestMapping(value="/formP", method = RequestMethod.POST)
public String guardar(Producto producto) {
	productoService.save(producto);
	return "redirect:listarP";
}

@RequestMapping(value="/formP/{id}")

public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
Producto producto= null;
	if(id>0) {
		producto=productoService.findOne(id);
	} else {
		return "redirect:/listarP";
	}
	model.put("producto", producto);
	model.put("titulo", "Actualizar Producto");
	return "formP";
}

@RequestMapping(value="/eliminar/{id}")
public String eliminar(@PathVariable(value="id")Long id) {
	if(id>0) {
		productoService.delete(id);
	}
	return "redirect:/listarP";
}

}
