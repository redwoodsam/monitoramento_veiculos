package br.com.aldbio.controle_veiculos.filas.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aldbio.controle_veiculos.filas.controller.dto.NewFilaRequestDTO;
import br.com.aldbio.controle_veiculos.filas.entity.Fila;
import br.com.aldbio.controle_veiculos.filas.service.FilaService;

@RestController
@RequestMapping("/api/filas")
@PreAuthorize("hasRole('ADMIN')")
public class FilaController {
	
	private final FilaService filaService;
	
	public FilaController(FilaService filaService) {
		this.filaService = filaService;
	}


	@GetMapping
	public List<Fila> listarTodos() {
		return this.filaService.getFilas();
	}
	
	@PostMapping
	public ResponseEntity<Fila> novaFila(@RequestBody NewFilaRequestDTO novaFila) {
		return ResponseEntity.ok(filaService.criarFila(novaFila.nome()));
	}
	

}
