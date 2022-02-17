package com.formacion.web.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.formacion.web.mvc.entity.Producto;
import com.formacion.web.mvc.service.ProductoService;

@Controller
public class ProductoController {

	@Autowired
	private ProductoService servicio;

	@GetMapping("/productos")
	public String listarProductos(Model model) {
		model.addAttribute("key", servicio.listarTodosLosProductos());
		return "productos";
	}

	@GetMapping("/productos/nuevo")
	public String formularioProducto(Model modelo) {
		Producto newProducto = new Producto();
		modelo.addAttribute("productoKey", newProducto);
		return "nuevo_producto";
	}

	@PostMapping("/productos")
	public String guardarProducto(@ModelAttribute("producto") Producto producto) {
		servicio.guardarProducto(producto);
		return "redirect:/productos";
	}

	@GetMapping("/productos/editar/{id}")
	public String formularioEdicionProducto(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("productoKey", servicio.obtenerProducto(id));
		return "editar_producto";
	}

	@PostMapping("/productos/editar/{id}")
	public String editarProducto(@PathVariable Long id, @ModelAttribute("productoKey") Producto producto) {
		Producto productoEdit = servicio.obtenerProducto(id);
		productoEdit.setNombre(producto.getNombre());
		productoEdit.setDescripcion(producto.getDescripcion());
		productoEdit.setExistencias(producto.getExistencias());
		productoEdit.setPrecio(producto.getPrecio());

		servicio.guardarProducto(productoEdit);
		return "redirect:/productos";
	}

	@GetMapping("/productos/borrar/{id}")
	public String eliminarProducto(@PathVariable Long id) {
		servicio.eliminarProducto(id);
		return "redirect:/productos";
	}
}
