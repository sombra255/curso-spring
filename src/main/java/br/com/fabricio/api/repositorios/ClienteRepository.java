package br.com.fabricio.api.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fabricio.api.documents.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
	Cliente findByNome(String nome);

	@Query("{ 'idade' : {$gt: ?0, $lt: $1} }")
	List<Cliente> findByIdadeBetween(int idadeInicial, int idadeFinal);
}
