package com.cibertec.ms_utenticacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsUtenticacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsUtenticacionApplication.class, args);
	}

}
