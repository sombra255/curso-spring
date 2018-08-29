package br.com.fabricio.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.fabricio.api.documents.Cliente;
import br.com.fabricio.api.entidades.Empresa;
import br.com.fabricio.api.repositorios.ClienteRepository;
import br.com.fabricio.api.repositorios.EmpresaRepository;
import br.com.fabricio.api.service.ExemploService;
import br.com.fabricio.api.utils.SenhaUtils;

@SpringBootApplication
public class MeuPrimeiroProjetoApplication {
	
	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private ExemploService exemploService;
	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(MeuPrimeiroProjetoApplication.class, args);
		System.out.println("Alteração da mensagem123...");
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("Elementos por página = "+qtdPorPagina);
//			encodeSenhaSpringSecurity();
//			consultasJPASpring();
//			exemploService.testarServico();
//			testeMongoDb();
		};
	}

	private void testeMongoDb() {
		clienteRepository.deleteAll();
		
		clienteRepository.save(new Cliente("Joao", 33));
		clienteRepository.save(new Cliente("Pedro", 18));
		clienteRepository.save(new Cliente("Maria", 26));
		clienteRepository.save(new Cliente("Ana", 22));
		
		System.out.println("Listar todos com o findAll(): \n ################### \n");
		clienteRepository.findAll().forEach(System.out :: println);
		System.out.println();
		
		System.out.println("Buscar um unico cliente com o nome: Joao \n ################### \n");
		System.out.println(clienteRepository.findByNome("Joao"));
		System.out.println();
		
		System.out.println("Cliente com idade entre 18 e 30 \n ################### \n");
		System.out.println(clienteRepository.findByIdadeBetween(18, 30));
		System.out.println();
		
	}

	private void consultasJPASpring() {
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("Empresa teste 1 LTDA");
		empresa.setCnpj("123456789");
		
		empresaRepository.save(empresa);
		
		List<Empresa> lsEmpresas = empresaRepository.findAll();
		lsEmpresas.forEach(System.out::println);
		
		Optional<Empresa> empresaDBOptional = empresaRepository.findById(1L);
		Empresa empresaDB = new Empresa();
		if(empresaDBOptional.isPresent()) {
			empresaDB = empresaDBOptional.get();
			System.out.println("Empresa por ID: "+empresaDB);
		}
		
		empresaDB.setRazaoSocial("Teste empresa web 234 LTDA");
		empresaRepository.save(empresaDB);
		
		Empresa empresaCnpj = empresaRepository.findByCnpj("123456789");
		System.out.println("Empresa por CNPJ : " + empresaCnpj);
		
		empresaRepository.deleteById(1L);
		lsEmpresas = empresaRepository.findAll();
		System.out.println("Empresas : "+lsEmpresas.size());
	}

	private void encodeSenhaSpringSecurity() {
		String senhaEncoded = SenhaUtils.geraBCrypt("123456");
		System.out.println("Senha encoded:" + senhaEncoded);
		
		senhaEncoded = SenhaUtils.geraBCrypt("123456");
		System.out.println("Senha encoded:" + senhaEncoded);
		
		System.out.println("Senha válida = " + SenhaUtils.senhaValida("123456", senhaEncoded));
	}
	
	
	
}
