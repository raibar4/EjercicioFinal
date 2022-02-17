package com.formacion.web.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.web.mvc.entity.Venta;
import com.formacion.web.mvc.service.VentaService;

@RestController
@RequestMapping("api")
public class VentaController {

	@Autowired
	private VentaService servicio;

	@GetMapping("ventas")
	public List<Venta> venta() {
		return servicio.listarTodasLasVentas();
	}

	@GetMapping("ventas/{id}")
	public ResponseEntity<?> ventaShow(@PathVariable Long id) {
		Venta venta = null;
		Map<String, Object> response = new HashMap<>();

		try {
			venta = servicio.obtenerVentaPorId(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar consulta a la base de datos.");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (venta == null) {
			response.put("mensaje", "El venta ID:".concat(id.toString().concat(" no existe en la base de datos.")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Venta>(venta, HttpStatus.OK);
	}

	@PostMapping("ventas")
	public ResponseEntity<?> saveVenta(@RequestBody Venta venta) {
		Venta ventaNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			ventaNew = servicio.guardarVenta(venta);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar insert en la base de datos.");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El venta ha sido creado con éxito!");
		response.put("", ventaNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	@PutMapping("ventas/{id}")
	public ResponseEntity<?> updateCliente(@RequestBody Venta venta, @PathVariable Long id) {

		Venta ventaEdit = servicio.obtenerVentaPorId(id);
		Map<String, Object> response = new HashMap<>();

		try {

			ventaEdit.setFolio(venta.getFolio());
			ventaEdit.setCantidad(venta.getCantidad());
			ventaEdit.setIva(venta.getIva());
			ventaEdit.setSubtotal(venta.getSubtotal());
			ventaEdit.setTotal(venta.getTotal());

			servicio.guardarVenta(ventaEdit);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la base de datos.");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El venta ha sido actualizado con éxito!");
		response.put("", ventaEdit);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("ventas/{id}")
	public ResponseEntity<?> deleteCliente(@PathVariable Long id) {
		Venta ventaBorrado = servicio.obtenerVentaPorId(id);
		Map<String, Object> response = new HashMap<>();

		try {

			servicio.eliminarVenta(id);
		}

		catch (DataAccessException e) {
			response.put("mensaje", "Error al borrar el venta de la base de datos.");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El venta ha sido borrado con éxito!");
		response.put("", ventaBorrado);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	/*
	 * @GetMapping("ventas/nuevo") public String formularioVenta(Model modelo) {
	 * Venta newVenta = new Venta(); modelo.addAttribute("ventaKey", newVenta);
	 * return "nuevo_venta"; }
	 * 
	 * @PostMapping("/ventas/nuevo") public String
	 * guardarVenta(@ModelAttribute("venta") Venta venta) {
	 * servicio.guardarVenta(venta); return "redirect:/ventas"; }
	 * 
	 * @GetMapping("/ventas/editar/{id}") public String
	 * formularioEdicionVenta(@PathVariable Long id, Model modelo) {
	 * modelo.addAttribute("ventaKey", servicio.obtenerVentaPorId(id)); return
	 * "editar_venta"; }
	 * 
	 * @PostMapping("/ventas/editar/{id}") public String editarVenta(@PathVariable
	 * Long id, @ModelAttribute("ventaKey") Venta venta) { Venta ventaEdit =
	 * servicio.obtenerVentaPorId(id); ventaEdit.setFolio(venta.getFolio());
	 * ventaEdit.setCantidad(venta.getCantidad()); ventaEdit.setIva(venta.getIva());
	 * ventaEdit.setSubtotal(venta.getSubtotal());
	 * ventaEdit.setTotal(venta.getTotal());
	 * 
	 * servicio.guardarVenta(ventaEdit); return "redirect:/ventas"; }
	 * 
	 * @DeleteMapping("/ventas/borrar/{id}") public String
	 * eliminarVenta(@PathVariable Long id) { servicio.eliminarVenta(id); return
	 * "redirect:/ventas"; }
	 */
}