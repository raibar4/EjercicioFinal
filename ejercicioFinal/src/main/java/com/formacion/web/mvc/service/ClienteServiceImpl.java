package com.formacion.web.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacion.web.mvc.dao.ClienteDao;
import com.formacion.web.mvc.entity.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDao clienteDao;

	@Override
	public List<Cliente> listarTodosLosClientes() {

		return clienteDao.findAll();
	}

	@Override
	public Cliente guardarCliente(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	public Cliente obtenerCliente(Long id) {
		return clienteDao.findById(id).get();
	}

	@Override
	public void eliminarCliente(Long id) {
		clienteDao.deleteById(id);

	}

}
