package br.com.aldbio.controle_veiculos.filas.service;

import org.springframework.stereotype.Service;

import br.com.aldbio.controle_veiculos.filas.repository.SenhaRepository;

@Service
public class SenhaService {
	
	private final SenhaRepository senhaRepository;

	public SenhaService(SenhaRepository senhaRepository) {
		this.senhaRepository = senhaRepository;
	}

	
	

}
