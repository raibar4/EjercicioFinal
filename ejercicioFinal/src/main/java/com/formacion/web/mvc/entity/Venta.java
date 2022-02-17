package com.formacion.web.mvc.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ventas")
public class Venta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private int folio;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producto_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Producto producto;

	@Column(nullable = false)
	private int cantidad;

	@Column(nullable = false)
	private double subtotal;

	@Column(nullable = false)
	private double iva;

	@Column(nullable = false)
	private double total;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getFolio() {
		return folio;
	}

	public void setFolio(int folio) {
		this.folio = folio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	private static final long serialVersionUID = 1L;

}
