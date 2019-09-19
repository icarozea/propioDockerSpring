package com.zea.ovidio.configuracion;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 * Clas {Configuration} configuración de Swagger
 * 
 * @author Ovidio Zea
 * 
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.zea.ovidio"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("CRUD de la tabla Clientes",
				"Micro-servicio encargado de administrar los datos del clinte y servicio que se conecta a Wsproductos por medio de JAX-RS", "1.0.0", "", null,
				"", "", Collections.emptyList());
	}
}