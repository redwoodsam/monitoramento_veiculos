package br.com.aldbio.controle_veiculos.filas.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "filas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Fila {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;
	
	@OneToOne
	@JoinColumn(name = "senha_atual_id")
	private Senha senhaAtual;
	
	@OneToMany(mappedBy = "fila")
	private List<Senha> senhas = new ArrayList<>();

	private boolean ativo = true;

	private boolean deleted = false;
	
	public Fila(String nome) {
		this.nome = nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void adicionarSenhaALista(Senha senha) {
		this.senhas.add(senha);
	}
	
	public void chamarSenha(Senha senha) {
		this.senhaAtual = senha;
	}

	public void apagar() {
		this.deleted = true;
	}
	
	public void inativar() {
		this.ativo = false;
	}

}
