package br.com.multiinovacoes.helpdesk.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import br.com.multiinovacoes.helpdesk.enums.ClienteEnum;
import br.com.multiinovacoes.helpdesk.enums.StatusEnum;


public class TicketDto implements Serializable{

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
	
	private Integer status;
	
	private Integer anoTicketGerado;
	
	private List<AnexoDto> listaAnexo;
	
	private List<ComplementoTicketDto> listaComplementoTicketDto;
	
	@SuppressWarnings("unused")
	private String descricaoStatus;
	
	@SuppressWarnings("unused")
	private String descricaoCliente;

	@SuppressWarnings("unused")
	private String descricaoUsuario;

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

	public void setDescricaoStatus(String descricaoStatus) {
		this.descricaoStatus = descricaoStatus;
	}

	public String getDescricaoStatus() {
		return StatusEnum.pegarDescricao(status).getDescricao();
	}

	public List<AnexoDto> getListaAnexo() {
		return listaAnexo;
	}

	public void setListaAnexo(List<AnexoDto> listaAnexo) {
		this.listaAnexo = listaAnexo;
	}

	public Integer getAnoTicketGerado() {
		return anoTicketGerado;
	}

	public void setAnoTicketGerado(Integer anoTicketGerado) {
		this.anoTicketGerado = anoTicketGerado;
	}

	public String getDescricaoCliente() {
		return ClienteEnum.pegarDescricao(codigoCliente).getDescricao();
	}

	public void setDescricaoCliente(String descricaoCliente) {
		this.descricaoCliente = descricaoCliente;
	}

	public List<ComplementoTicketDto> getListaComplementoTicketDto() {
		return listaComplementoTicketDto;
	}

	public void setListaComplementoTicketDto(List<ComplementoTicketDto> listaComplementoTicketDto) {
		this.listaComplementoTicketDto = listaComplementoTicketDto;
	}

	public String getDescricaoUsuario() {
		return descricaoUsuario;
	}

	public void setDescricaoUsuario(String descricaoUsuario) {
		this.descricaoUsuario = descricaoUsuario;
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
		TicketDto other = (TicketDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
