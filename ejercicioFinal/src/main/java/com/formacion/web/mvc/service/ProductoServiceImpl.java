package com.formacion.web.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacion.web.mvc.dao.ProductoDao;
import com.formacion.web.mvc.entity.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDao productoDao;

	@Override
	public List<Producto> listarTodosLosProductos() {

		return productoDao.findAll();
	}

	@Override
	public Producto guardarProducto(Producto producto) {
		return productoDao.save(producto);
	}

	@Override
	public Producto obtenerProducto(Long id) {
		return productoDao.findById(id).get();
	}

	@Override
	public void eliminarProducto(Long id) {
		productoDao.deleteById(id);

	}

}
