package br.com.aldbio.controle_veiculos.filas.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "sessoes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sessao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Guiche guiche;
	
	@OneToOne
	private Colaborador colaborador;
	
	@OneToMany
	private List<Fila> filas = new ArrayList<>();
	
	private LocalDateTime dataLogon = LocalDateTime.now();
	
	private boolean ativo = true;
	
	private boolean deleted = false;
	
}
