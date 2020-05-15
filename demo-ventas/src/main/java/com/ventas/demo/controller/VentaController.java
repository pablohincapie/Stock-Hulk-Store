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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ventas.demo.common.Util;
import com.ventas.demo.model.Producto;
import com.ventas.demo.model.Venta;
import com.ventas.demo.service.api.ProductoServiceAPI;
import com.ventas.demo.service.api.VentaServiceAPI;

/**
 * Controlador donde se desarrolla las acciones de una venta.
 * 
 * @author Pablo Hincapie Creado el 09/05/2020 a 03:18:33 pm <br>
 */
@Controller
@Configuration
@PropertySource(value = { "classpath:mensajes.properties" })
public class VentaController {
	@Autowired
	private VentaServiceAPI ventaServiceAPI;
	@Autowired
	private Util util;
	@Autowired
	private ProductoServiceAPI productoServiceAPI;
	@Value("${informacion.producto.inexistente}")
	private String invalidCantidad;
	@Value("${informacion.save.success}")
	private String info;

	/**
	 * Metodo que lista la informacion de la entidad venta
	 * 
	 * @author Pablo Hincapie Creado el 09/05/2020 a 02:44:19 pm <br>
	 * @param model
	 * @return
	 */
	@RequestMapping("/venta")
	public String index(Model model) {
		ventaServiceAPI.getAll();
		model.addAttribute("venta", ventaServiceAPI.getAll());
		return "viewVenta";
	}

	/**
	 * Metodo que edita un elemento.
	 * 
	 * @author Pablo Hincapie Creado el 09/05/2020 a 03:41:24 pm <br>
	 * @param model
	 * @return
	 */
	@GetMapping("/saveVenta/{id_venta}")
	public String showSave(@PathVariable("id_venta") Long id_venta, Model model) {
		if (id_venta != null && id_venta != 0) {
			model.addAttribute("venta", ventaServiceAPI.get(id_venta));
		} else {
			model.addAttribute("venta", new Venta());
		}
		return "saveVenta";
	}

	/**
	 * Metodo que guarda una venta.
	 * 
	 * @author Pablo Hincapie Creado el 09/05/2020 a 02:48:42 pm <br>
	 * @param venta
	 * @param model
	 * @param redirectAttrs
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/saveVenta")
	public String save(Venta venta, Model model, RedirectAttributes redirectAttrs) throws Exception {
		Date fecha = new Date();
		venta.setFecha_venta(fecha);

		int cantidad = venta.getCantidad();
		float precio = venta.getPrecio();
		float total = util.calcularTotal(cantidad, precio);
		venta.setTotal(total);

		Producto productoResult = isValidVenta(venta);
		if (productoResult != null && productoResult.getCantidad() > venta.getCantidad()) {
			ventaServiceAPI.save(venta);
			Producto producto = new Producto();
			producto.setCantidad(productoResult.getCantidad() - venta.getCantidad());
			producto.setReferencia(venta.getReferencia());
			productoServiceAPI.updateProducto(producto);
			model.addAttribute("success", info);
		} else {
			model.addAttribute("invalid", invalidCantidad);
			model.addAttribute("venta", new Venta());
		}
		return "viewVenta";
	}

	/**
	 ** Valida que exista el producto.
	 * 
	 * @author Pablo Hincapie Creado el 09/05/2020 a 04:02:14 pm <br>
	 * @param venta
	 * @return
	 * @throws Exception
	 */
	@Qualifier(value = "productoServiceAPI")
	private Producto isValidVenta(Venta venta) throws Exception {
		Producto productoResult = productoServiceAPI.findProductoByReferencia(venta.getReferencia());
		return productoResult;
	}

}
