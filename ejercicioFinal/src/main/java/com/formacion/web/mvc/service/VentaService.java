package com.formacion.web.mvc.service;

import java.util.List;

import com.formacion.web.mvc.entity.Venta;

public interface VentaService {

	public List<Venta> listarTodasLasVentas();

	public Venta guardarVenta(Venta venta);

	public Venta obtenerVentaPorId(Long id);

	public void eliminarVenta(Long id);

}
