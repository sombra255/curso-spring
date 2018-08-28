package br.com.fabricio.api.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabricio.api.dto.EmpresaDTO;
import br.com.fabricio.api.response.Response;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {
	
	@PostMapping
	public ResponseEntity<Response<EmpresaDTO>> cadastrar(@Valid @RequestBody EmpresaDTO empresaDTO, BindingResult result){
		Response<EmpresaDTO> response = new Response<EmpresaDTO>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getLsErros().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		empresaDTO.setId(1L);
		response.setData(empresaDTO);
		
		return ResponseEntity.ok(response);
	}

}
