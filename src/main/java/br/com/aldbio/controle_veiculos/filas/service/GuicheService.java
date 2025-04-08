package br.com.aldbio.controle_veiculos.filas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.aldbio.controle_veiculos.filas.entity.Guiche;
import br.com.aldbio.controle_veiculos.filas.repository.GuicheRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class GuicheService {

	private final GuicheRepository guicheRepository;

	public GuicheService(GuicheRepository guicheRepository) {
		this.guicheRepository = guicheRepository;
	}

	public List<Guiche> getGuiches() {
		return this.guicheRepository.findAll();
	}

	public Guiche buscaGuichePorId(Long id) {
		return this.guicheRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Fila não encontrada"));
	}

	public Guiche criarGuiche(String nome) {
		return this.guicheRepository.save(new Guiche(nome));
	}

	public Guiche editarGuiche(Long id, String novoNome) {
		Guiche guicheEncontrado = buscaGuichePorId(id);
		guicheEncontrado.setNome(novoNome);
		return this.guicheRepository.save(guicheEncontrado);
	}

	public void apagaGuiche(Long id) {

		Guiche guicheEncontrado = buscaGuichePorId(id);
		guicheEncontrado.apagar();
		
		guicheRepository.save(guicheEncontrado);

	}
}
