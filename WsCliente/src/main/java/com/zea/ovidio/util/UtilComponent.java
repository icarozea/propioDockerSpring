package com.zea.ovidio.util;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Component;

/**
 * @author OZEA
 *
 */
@Component
public class UtilComponent {

	@Autowired
	private ServerProperties serverProperties;

	public static final int UTF8_BOM_LENGTH = 3;


	/**
	 * Método que carga el keystore con el certificado, y lo setea en un contexto
	 * SSL para que este a su vez e utilice en el consumo del microservicio por
	 * HTTPS
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException  Si ocurre un error al momento de
	 *                                   inicializar el contexto SSL para el consumo
	 *                                   del método de la API por HTTPS
	 * @throws KeyStoreException         Si ocurre un error al momento de
	 *                                   inicializar el contexto SSL para el consumo
	 *                                   del método de la API por HTTPS
	 * @throws CertificateException      Si ocurre un error al momento de
	 *                                   inicializar el contexto SSL para el consumo
	 *                                   del método de la API por HTTPS
	 * @throws IOException               Si ocurre un error al momento de
	 *                                   inicializar el contexto SSL para el consumo
	 *                                   del método de la API por HTTPS
	 * @throws UnrecoverableKeyException Si ocurre un error al momento de
	 *                                   inicializar el contexto SSL para el consumo
	 *                                   del método de la API por HTTPS
	 * @throws KeyManagementException    Si ocurre un error al momento de
	 *                                   inicializar el contexto SSL para el consumo
	 *                                   del método de la API por HTTPS
	 */
	public SSLContext getSSLContextFromKeystore() throws NoSuchAlgorithmException, KeyStoreException,
			CertificateException, IOException, UnrecoverableKeyException, KeyManagementException {

		SSLContext sslContext = null;
		KeyManagerFactory keyMgrFactory = null;
		KeyStore keyStore = null;
		TrustManagerFactory tmf = null;

		sslContext = SSLContext.getInstance("TLSv1.2");

		keyMgrFactory = KeyManagerFactory.getInstance("SunX509");
		keyStore = KeyStore.getInstance("JKS");
		keyStore.load(getClass().getClassLoader().getResourceAsStream(serverProperties.getSsl().getKeyStore()),
				serverProperties.getSsl().getKeyPassword().toCharArray());

		keyMgrFactory.init(keyStore, serverProperties.getSsl().getKeyPassword().toCharArray());

		tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		tmf.init(keyStore);

		sslContext.init(keyMgrFactory.getKeyManagers(), tmf.getTrustManagers(), null);
		return sslContext;
	}

	/**
	 * Método que carga el keystore con el certificado, y lo setea en un contexto
	 * SSL para que este a su vez e utilice en el consumo del microservicio por
	 * HTTPS
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException  Si ocurre un error al momento de
	 *                                   inicializar el contexto SSL para el consumo
	 *                                   del método de la API por HTTPS
	 * @throws KeyStoreException         Si ocurre un error al momento de
	 *                                   inicializar el contexto SSL para el consumo
	 *                                   del método de la API por HTTPS
	 * @throws CertificateException      Si ocurre un error al momento de
	 *                                   inicializar el contexto SSL para el consumo
	 *                                   del método de la API por HTTPS
	 * @throws IOException               Si ocurre un error al momento de
	 *                                   inicializar el contexto SSL para el consumo
	 *                                   del método de la API por HTTPS
	 * @throws UnrecoverableKeyException Si ocurre un error al momento de
	 *                                   inicializar el contexto SSL para el consumo
	 *                                   del método de la API por HTTPS
	 * @throws KeyManagementException    Si ocurre un error al momento de
	 *                                   inicializar el contexto SSL para el consumo
	 *                                   del método de la API por HTTPS
	 */
	public SSLContext getSSLContextInsecure() throws NoSuchAlgorithmException, KeyManagementException {

		SSLContext sslContext = null;
		sslContext = SSLContext.getInstance("TLS");
		sslContext.init(null, new TrustManager[] { new X509TrustManager() {
			public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
			}

			public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
			}

			public X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[0];
			}

		} }, new java.security.SecureRandom());

		return sslContext;
	}

}
