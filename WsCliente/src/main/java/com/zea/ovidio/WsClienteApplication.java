package com.zea.ovidio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.zea.ovidio.configuracion.WsProperties;



@EnableConfigurationProperties(WsProperties.class)
@SpringBootApplication
public class WsClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsClienteApplication.class, args);
	}

}
