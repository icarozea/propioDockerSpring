package com.zea.ovidio.repository;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zea.ovidio.configuracion.WsProperties;
import com.zea.ovidio.model.Compras;
import com.zea.ovidio.util.UtilComponent;

@Repository
public class ProductosRestRepository {

	@Autowired
	private UtilComponent utilComponent;

	@Autowired
	private WsProperties wsProperties;

	/**
	 * @param idCliente
	 * @return
	 * @throws UnrecoverableKeyException
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyStoreException
	 * @throws CertificateException
	 * @throws CustomerException
	 */

	public List<Compras> getComprasByIdCliente(Integer idCliente) throws UnrecoverableKeyException, KeyManagementException,
			NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException, Exception {
		Response response = null;
		String strResponse = null;
		ObjectMapper mapper = null;
		UriComponentsBuilder uriBuilder = null;

		SSLContext sslContext = utilComponent.getSSLContextInsecure();
		StringBuilder url = new StringBuilder("");
		List<Compras> compras = null;

		if (StringUtils.isEmpty(wsProperties.getEndPointProductos())) {
			throw new RuntimeException("El endpoint no se encuentra parametrizado");
		}

		url.append(wsProperties.getEndPointProductos()).append("/").append("productos/").append(idCliente);

		System.out.println(url.toString());

		uriBuilder = UriComponentsBuilder.fromHttpUrl(url.toString());

		response = ClientBuilder.newBuilder().sslContext(sslContext).register(JacksonJsonProvider.class).build()
				.target(uriBuilder.toUriString()).request(MediaType.APPLICATION_JSON).get();

		if (response.getStatus() != 200) {
			throw new RuntimeException(
					String.format("Failed : HTTP error code %s - %s", response.getStatus(), response.getStatusInfo()));
		}

		strResponse = response.readEntity(String.class);
		
		System.out.println(strResponse);

		mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		compras =  mapper.readValue(strResponse, new TypeReference<List<Compras>>(){});

		return compras;
	}

}
