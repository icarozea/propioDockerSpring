package com.zea.ovidio.configuracion;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>
 * Clase que realiza el mapeo de la configuración presente en el archivo
 * properties del proyecto, directamente a las variables de la misma
 * 
 * @author ozea
 *
 */
@ConfigurationProperties(prefix = "com.zea.ovidio.parametro")
public class WsProperties {


	private String endPointProductos;


	public WsProperties() {
		super();
	}


	public String getEndPointProductos() {
		return endPointProductos;
	}


	public void setEndPointProductos(String endPointProductos) {
		this.endPointProductos = endPointProductos;
	}

	

}
