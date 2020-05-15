package com.ventas.demo.propiedades.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Clase utilitaria de configuraciones
 * @author Pablo Hincapie Creado el 10/05/2020 a 09:49:44 pm <br>
 *
 */
// @PropertySource("mensajes.properties")

@Configuration
// @PropertySource("classpath:mensajes.properties")
/*@PropertySource(value = { "classpath:mensajes.properties" })
/@ComponentScan(basePackages = "com.ventas.demo.controller")*/
public class PropertiesSource {

	/*@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	public PropertiesSource() {
		super();
		throw new NullPointerException();
	}*/

}
