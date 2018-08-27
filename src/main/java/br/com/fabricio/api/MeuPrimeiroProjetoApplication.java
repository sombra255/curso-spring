package br.com.fabricio.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.fabricio.api.utils.SenhaUtils;

@SpringBootApplication
public class MeuPrimeiroProjetoApplication {
	
	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;

	public static void main(String[] args) {
		SpringApplication.run(MeuPrimeiroProjetoApplication.class, args);
		System.out.println("Alteração da mensagem123...");
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
//			System.out.println("Elementos por página = "+qtdPorPagina);
			String senhaEncoded = SenhaUtils.geraBCrypt("123456");
			System.out.println("Senha encoded:" + senhaEncoded);
			
			senhaEncoded = SenhaUtils.geraBCrypt("123456");
			System.out.println("Senha encoded:" + senhaEncoded);
			
			System.out.println("Senha válida = " + SenhaUtils.senhaValida("123456", senhaEncoded));
		};
	}
	
	
	
}
