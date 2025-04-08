package br.com.aldbio.controle_veiculos.filas.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aldbio.controle_veiculos.filas.controller.dto.NewGuicheRequestDTO;
import br.com.aldbio.controle_veiculos.filas.entity.Guiche;
import br.com.aldbio.controle_veiculos.filas.service.GuicheService;

@RestController
@RequestMapping("/api/guiches")
@PreAuthorize("hasRole('ADMIN')")
public class GuicheController {
	
	private final GuicheService guicheService;
	
	public GuicheController(GuicheService guicheService) {
		this.guicheService = guicheService;
	}


	@GetMapping
	public List<Guiche> listarTodos() {
		return this.guicheService.getGuiches();
	}
	
	@PostMapping
	public Guiche novaGuiche(@RequestBody NewGuicheRequestDTO novoGuiche) {
		return guicheService.criarGuiche(novoGuiche.nome());
	}
}
