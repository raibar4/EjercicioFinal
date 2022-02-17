package com.formacion.web.mvc.service;
import java.util.List;

import com.formacion.web.mvc.entity.Producto;


public interface ProductoService {

	public List<Producto> listarTodosLosProductos();
	
	public Producto guardarProducto(Producto producto);
	
	public Producto obtenerProducto(Long id);
	
	public void eliminarProducto(Long id);
}
