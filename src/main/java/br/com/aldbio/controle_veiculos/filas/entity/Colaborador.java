package br.com.aldbio.controle_veiculos.filas.entity;

import br.com.aldbio.controle_veiculos.auth.entity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "colaboradores")
public class Colaborador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String cargo;
	private String departamento;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private User user;
	
	private boolean ativo = true;
	
	private boolean deleted = false;
	
}
