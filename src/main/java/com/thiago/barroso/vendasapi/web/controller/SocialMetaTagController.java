package com.thiago.barroso.vendasapi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thiago.barroso.vendasapi.domain.SocialMetaTag;
import com.thiago.barroso.vendasapi.service.SocialMetaTagService;

@Controller
@RequestMapping("/meta")
public class SocialMetaTagController {

	@Autowired
	SocialMetaTagService socialMetaTagService;
	
	@PostMapping("/info")
	public ResponseEntity<SocialMetaTag> getDadosViaUrl(@RequestParam("url") String url){
		
		
		return socialMetaTagService.getSocialMetaTagByUrl(url)
	            .map(ResponseEntity::ok) // Se presente, retorna 200 OK com o objeto
	            .orElseGet(() -> ResponseEntity.notFound().build()); // Se vazio, retorna 404
	}
	
}
