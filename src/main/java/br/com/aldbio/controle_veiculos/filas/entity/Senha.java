package br.com.aldbio.controle_veiculos.filas.entity;

import java.time.LocalDateTime;

import br.com.aldbio.controle_veiculos.filas.enums.StatusSenhaEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "senhas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Senha {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeMotorista;
	
	private String telefone;
	
	@ManyToOne
	private Fila fila;
	
	private LocalDateTime dataEmissao = LocalDateTime.now();

	private LocalDateTime ultimaChamada;
	
	@Enumerated(EnumType.STRING)
	private StatusSenhaEnum status = StatusSenhaEnum.AGUARDANDO_CHAMADA;
	
	
	public void iniciarAtendimento() {
		this.status = StatusSenhaEnum.EM_ATENDIMENTO;
		this.ultimaChamada = LocalDateTime.now();
	}
	
	public void colocarComoEmTransito() {
		this.status = StatusSenhaEnum.EM_TRANSITO;
	}
	
	public void concluirAtendimento() {
		this.status = StatusSenhaEnum.ATENDIDA;
	}
	
	public void colocarComoNaoAtendida() {
		this.status = StatusSenhaEnum.NAO_ATENDIDA;
	}
	
	public void invalidar() {
		this.status = StatusSenhaEnum.EXPIRADA;
	}
	
	
}
