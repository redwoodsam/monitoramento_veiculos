package br.com.aldbio.controle_veiculos.filas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aldbio.controle_veiculos.filas.entity.Senha;

public interface SenhaRepository extends JpaRepository<Senha, Long> {

}
