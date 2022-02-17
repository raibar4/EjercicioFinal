package com.formacion.web.mvc.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.formacion.web.mvc.entity.Producto;


public interface ProductoDao extends JpaRepository<Producto, Long>{

	
	
}
