package com.example.demosoap;

// Importaciones necesarias para la configuración del servlet inicializador
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// Clase que configura el servlet inicializador para la aplicación Spring Boot
public class ServletInitializer extends SpringBootServletInitializer {

	// Método que configura la aplicación
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		// Retorna la configuración de la aplicación, especificando la clase principal
		return application.sources(DemoSoapApplication.class);
	}
}
