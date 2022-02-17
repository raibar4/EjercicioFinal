package com.formacion.web.mvc.service;

import java.util.List;

import com.formacion.web.mvc.entity.Cliente;

public interface ClienteService {

	public List<Cliente> listarTodosLosClientes();

	public Cliente guardarCliente(Cliente cliente);

	public Cliente obtenerCliente(Long id);

	public void eliminarCliente(Long id);
}
