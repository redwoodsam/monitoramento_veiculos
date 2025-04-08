package br.com.aldbio.controle_veiculos.filas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aldbio.controle_veiculos.filas.entity.Fila;

public interface FilaRepository extends JpaRepository<Fila, Long> {
	
	List<Fila> findByNomeLikeIgnoreCase(String nome);

}
