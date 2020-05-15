package com.ventas.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ventas.demo.model.Producto;
import com.ventas.demo.service.api.ProductoServiceAPI;

/**
 * Controlador donde se desarrolla las acciones de un producto.
 * 
 * @author Pablo Hincapie Creado el 09/05/2020 a 01:59:24 pm <br>
 */
@Controller
@Configuration
@PropertySource("classpath:mensajes.properties")
public class ProductoController {
	@Value("${informacion.save.success}")
	private String info;

	@Value("${informacion.delete.success}")
	private String delete;

	@Autowired
	private ProductoServiceAPI productoServiceAPI;

	/**
	 * Metodo que lista la informacion de la entidad producto
	 * 
	 * @author Pablo Hincapie Creado el 09/05/2020 a 02:44:19 pm <br>
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list", productoServiceAPI.getAll());

		return "index";
	}

	/**
	 * Metodo que edita un elemento.
	 * 
	 * @author Pablo Hincapie Creado el 09/05/2020 a 02:48:42 pm <br>
	 * @param model
	 * @return
	 */
	@GetMapping("/save/{id_producto}")
	public String showSave(@PathVariable("id_producto") Long id_producto, Model model) {
		if (id_producto != null && id_producto != 0) {
			model.addAttribute("producto", productoServiceAPI.get(id_producto));
		} else {
			model.addAttribute("producto", new Producto());
		}
		return "save";
	}

	/**
	 * Metodo que guarda un producto.
	 * 
	 * @author Pablo Hincapie Creado el 09/05/2020 a 03:01:21 pm <br>
	 * @param compra
	 * @param model
	 * @return
	 */
	@PostMapping("/save")
	public String save(Producto producto, Model model) {
		productoServiceAPI.save(producto);
		model.addAttribute("success", info);
		return "redirect:/";
	}

	/**
	 * Metodo que elimina un elemento por id.
	 * 
	 * @param id_producto
	 * @param model
	 * @return
	 */
	@GetMapping("/delete/{id_producto}")
	public String delete(@PathVariable Long id_producto, Model model) {
		productoServiceAPI.delete(id_producto);

		model.addAttribute("successdelete", delete);
		return "redirect:/";
	}

}