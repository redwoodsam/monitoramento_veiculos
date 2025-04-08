package br.com.aldbio.controle_veiculos.filas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.aldbio.controle_veiculos.filas.entity.Fila;
import br.com.aldbio.controle_veiculos.filas.repository.FilaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FilaService {

	private final FilaRepository filaRepository;

	public FilaService(FilaRepository filaRepository) {
		this.filaRepository = filaRepository;
	}

	public List<Fila> getFilas() {
		return this.filaRepository.findAll();
	}
	
	public Fila buscaFilaPorId(Long id) {
		return this.filaRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Fila não encontrada"));
	}
	
	public List<Fila> buscaFilaPorNome(String nome) {
		return this.filaRepository.findByNomeLikeIgnoreCase(nome);
	}
	
	public Fila criarFila(String nome) {
		return this.filaRepository.save(new Fila(nome));
	}
	
	public Fila editarFila(Long id, String novoNome) {
		Fila filaEncontrada = buscaFilaPorId(id);
		filaEncontrada.setNome(novoNome);
		return this.filaRepository.save(filaEncontrada);
	}
	
	public void apagaFila(Long id) {
		
		Fila filaEncontrada = buscaFilaPorId(id);
		filaEncontrada.apagar();
		
		filaRepository.save(filaEncontrada);
	}
	
	
}
