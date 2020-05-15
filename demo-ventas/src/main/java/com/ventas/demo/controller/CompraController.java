package com.ventas.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ventas.demo.common.Util;
import com.ventas.demo.model.Compra;
import com.ventas.demo.model.Producto;
import com.ventas.demo.service.api.CompraServiceAPI;
import com.ventas.demo.service.api.ProductoServiceAPI;

/**
 * Controlador donde se desarrolla las acciones de una compra.
 * 
 * @author Pablo Hincapie Creado el 09/05/2020 a 01:56:38 pm <br>
 * 
 */

@Controller
@Configuration
@PropertySource(value = { "classpath:mensajes.properties" })
public class CompraController {

	@Value("${informacion.save.success}")
	private String info;
	
	@Autowired
	private CompraServiceAPI compraServiceAPI;

	@Autowired
	private Util util;

	@Autowired
	private ProductoServiceAPI productoServiceAPI;

	/**
	 * Metodo que lista la informacion de la entidad compra
	 * 
	 * @author Pablo Hincapie Creado el 09/05/2020 a 02:42:11 pm <br>
	 * @param model
	 * @return
	 */
	@RequestMapping("/compra")
	public String index(Model model) {
		model.addAttribute("compra", compraServiceAPI.getAll());
		return "viewCompra";
	}

	/**
	 * Metodo que edita un elemento.
	 * 
	 * @author Pablo Hincapie Creado el 09/05/2020 a 02:42:11 pm <br>
	 * @param model
	 * @return
	 */
	@GetMapping("/saveCompra/{id_compra}")
	public String showSave(@PathVariable("id_compra") Long id_compra, Model model) {
		if (id_compra != null && id_compra != 0) {
			model.addAttribute("compra", compraServiceAPI.get(id_compra));
		} else {
			model.addAttribute("compra", new Compra());
		}
		return "saveCompra";
	}

	/**
	 * Metodo que guarda una compra de un producto.
	 * 
	 * @author Pablo Hincapie Creado el 09/05/2020 a 02:33:35 pm <br>
	 * @param compra
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/saveCompra")
	public String save(Compra compra, Model model) throws Exception {
		Date fecha = new Date();
		compra.setFecha_compra(fecha);

		int cantidad = compra.getCantidad();
		float precio = compra.getPrecio();
		float total = util.calcularTotal(cantidad, precio);
		compra.setTotal(total);

		compraServiceAPI.save(compra);

		this.updateProducto(compra);
		model.addAttribute("success", info);
		model.addAttribute("compra", compraServiceAPI.getAll());
		return "viewCompra";
	}

	/**
	 * Metodo que actualiza la información en la entidad producto.
	 * 
	 * @author Pablo Hincapie Creado el 09/05/2020 a 02:41:05 pm <br>
	 * @param compra
	 * @throws Exception
	 */
	@Qualifier(value = "productoServiceAPI")
	private void updateProducto(Compra compra) throws Exception {

		Producto productoResult = productoServiceAPI.findProductoByReferencia(compra.getReferencia());

		Producto producto = new Producto();

		if (productoResult.getId_producto() == null) {
			producto.setCantidad(compra.getCantidad());
			producto.setDescripcion(compra.getDescripcion());
			producto.setPrecio(compra.getPrecio());
			producto.setReferencia(compra.getReferencia());
			productoServiceAPI.save(producto);
		} else {
			producto.setCantidad(compra.getCantidad() + productoResult.getCantidad());
			producto.setReferencia(compra.getReferencia());
			productoServiceAPI.updateProducto(producto);
		}

	}
}
