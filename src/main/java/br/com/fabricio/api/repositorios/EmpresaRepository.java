package br.com.fabricio.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fabricio.api.entidades.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	Empresa findByCnpj(String cnpj);

}
