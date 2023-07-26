package br.com.multiinovacoes.helpdesk.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "TICKET")
public class Ticket implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2700574673164534419L;
	
	
	@Id
	@Column(name = "CODIGO_TICKET")
	private Long id;

	@Column(name = "CODIGO_CLIENTE")
	private Integer codigoCliente;

	@Column(name = "CODIGO_TIPO")
	private Long codigoTipo;

	@Column(name = "CODIGO_PRIORIDADE")
	private Long codigoPrioridade;

	@Column(name = "CODIGO_USUARIO")
	private Long codigoUsuario;

	@Column(name = "NUMERO_TICKET")
	private Long numeroTicket;

	@NotBlank(message = "Nome é obrigatório")
	@Column(name = "ASSUNTO")
	private String assunto;

	@Column(name = "DESCRICAO")
	private String descricao;
	
	@Column(name = "DESCRICAO_SOLUCAO")
	private String descricaoSolucao;

	@Column(name = "DATA_ABERTURA")
	private LocalDateTime dataAbertura;
	
	@Column(name = "DATA_INICIO_ANALISE")
	private LocalDateTime dataInicioAnalise;

	@Column(name = "DATA_FECHAMENTO")
	private LocalDateTime dataFechamento;

	@Column(name = "STATUS")
	private Integer status;
	
	@Column(name = "ANO_TICKET_GERADO")
	private Integer anoTicketGerado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public Long getCodigoTipo() {
		return codigoTipo;
	}

	public void setCodigoTipo(Long codigoTipo) {
		this.codigoTipo = codigoTipo;
	}

	public Long getCodigoPrioridade() {
		return codigoPrioridade;
	}

	public void setCodigoPrioridade(Long codigoPrioridade) {
		this.codigoPrioridade = codigoPrioridade;
	}

	public Long getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public Long getNumeroTicket() {
		return numeroTicket;
	}

	public void setNumeroTicket(Long numeroTicket) {
		this.numeroTicket = numeroTicket;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricaoSolucao() {
		return descricaoSolucao;
	}

	public void setDescricaoSolucao(String descricaoSolucao) {
		this.descricaoSolucao = descricaoSolucao;
	}

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDateTime getDataInicioAnalise() {
		return dataInicioAnalise;
	}

	public void setDataInicioAnalise(LocalDateTime dataInicioAnalise) {
		this.dataInicioAnalise = dataInicioAnalise;
	}

	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getAnoTicketGerado() {
		return anoTicketGerado;
	}

	public void setAnoTicketGerado(Integer anoTicketGerado) {
		this.anoTicketGerado = anoTicketGerado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
