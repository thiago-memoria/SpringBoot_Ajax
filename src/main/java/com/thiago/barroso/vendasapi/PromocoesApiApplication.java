package com.thiago.barroso.vendasapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thiago.barroso.vendasapi.service.SocialMetaTagService;

@SpringBootApplication
public class PromocoesApiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PromocoesApiApplication.class, args);
	}
	
	@Autowired
	SocialMetaTagService service;
	
	@Override
	public void run(String... args) throws Exception {
		
	}

}
	