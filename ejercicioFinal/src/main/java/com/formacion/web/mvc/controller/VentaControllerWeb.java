package com.formacion.web.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.formacion.web.mvc.service.VentaService;

@Controller
public class VentaControllerWeb {

	@Autowired
	private VentaService servicio;
	
	@GetMapping("/ventas")
	public String listarProductos(Model model) {
		model.addAttribute("key", servicio.listarTodasLasVentas());
		return "ventas";
	}
}
