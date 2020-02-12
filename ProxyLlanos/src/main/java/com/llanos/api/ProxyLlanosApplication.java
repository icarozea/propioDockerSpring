package com.llanos.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ProxyLlanosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyLlanosApplication.class, args);
	}

}
