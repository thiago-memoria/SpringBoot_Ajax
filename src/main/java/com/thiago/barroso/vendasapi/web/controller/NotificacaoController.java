package com.thiago.barroso.vendasapi.web.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.thiago.barroso.vendasapi.domain.Emissor;
import com.thiago.barroso.vendasapi.repository.PromocaoRepository;
import com.thiago.barroso.vendasapi.service.NotificacaoService;

@Controller
public class NotificacaoController {
	
	@Autowired
	PromocaoRepository promocaoRepository;
	
	@Autowired
	private NotificacaoService notificacaoService;
	
	@GetMapping("/promocao/notificacao")
	public SseEmitter enviarNotificacao() throws IOException {
		
		SseEmitter emitter = new SseEmitter(0L);
		
		Emissor emissor = new Emissor(emitter, getDtCadastroUltimaPromocao());
		notificacaoService.onOpen(emissor);
		notificacaoService.addEmissor(emissor);
		
		emissor.getEmitter().onCompletion(() -> notificacaoService.removeEmissor(emissor));
		System.out.println("> size after add: " + notificacaoService.getEmissores().size());
		
		return emissor.getEmitter();		
	}
	
	private LocalDateTime getDtCadastroUltimaPromocao() {
		return promocaoRepository.findPromocaoComUltimaData();
	}
}
