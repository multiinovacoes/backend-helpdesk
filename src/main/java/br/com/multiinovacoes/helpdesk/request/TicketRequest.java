package br.com.multiinovacoes.helpdesk.request;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import br.com.multiinovacoes.helpdesk.dto.ListaAnexoDto;
import io.swagger.annotations.ApiModelProperty;


public class TicketRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2700574673164534419L;
	
	private Long id;

	private Integer codigoCliente;

	private Long codigoTipo;

	private Long codigoPrioridade;

	private Long codigoUsuario;

	private Long numeroTicket;

	private String assunto;

	private String descricao;
	
	private String descricaoSolucao;

	private LocalDateTime dataAbertura;
	
	private LocalDateTime dataInicioAnalise;

	private LocalDateTime dataFechamento;
	
	private String status;
	
	private Integer anoTicketGerado;
	
	@ApiModelProperty(value = "Lista de anexos")
	private List<ListaAnexoDto> listaAnexoDto;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<ListaAnexoDto> getListaAnexoDto() {
		return listaAnexoDto;
	}

	public void setListaAnexoDto(List<ListaAnexoDto> listaAnexoDto) {
		this.listaAnexoDto = listaAnexoDto;
	}
	
	


	public Integer getAnoTicketGerado() {
		return anoTicketGerado;
	}

	public void setAnoTicketGerado(Integer anoTicketGerado) {
		this.anoTicketGerado = anoTicketGerado;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	

}
