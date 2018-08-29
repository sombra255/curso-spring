package br.com.fabricio.api.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
public class Cliente {
	
	@Id
	private String id;
	private String nome;
	private Integer idade;
	
	public Cliente() {
	}
	

	public Cliente(String nome, Integer idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", idade=" + idade + "]";
	}
	
	

}
