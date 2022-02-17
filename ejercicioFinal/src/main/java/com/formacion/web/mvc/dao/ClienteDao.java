package com.formacion.web.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formacion.web.mvc.entity.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Long> {

}
