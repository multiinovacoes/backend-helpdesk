package br.com.multiinovacoes.helpdesk.request;

import java.io.Serializable;
import java.time.LocalDateTime;


public class ComplementoTicketRequest implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6035473800035010929L;
	
	private Long id;

	private Long codigoTicket;

	private Long codigoUsuario;

	private String descricaoComplemento;
	
	private String descricaoResposta;
	
	private Integer codigoUsuarioResposta;
	
	private LocalDateTime data;
	
	private LocalDateTime dataResposta;
	
	private Integer tipoComplemento;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigoTicket() {
		return codigoTicket;
	}

	public void setCodigoTicket(Long codigoTicket) {
		this.codigoTicket = codigoTicket;
	}

	public Long getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	
	public String getDescricaoComplemento() {
		return descricaoComplemento;
	}

	public void setDescricaoComplemento(String descricaoComplemento) {
		this.descricaoComplemento = descricaoComplemento;
	}

	public String getDescricaoResposta() {
		return descricaoResposta;
	}

	public void setDescricaoResposta(String descricaoResposta) {
		this.descricaoResposta = descricaoResposta;
	}

	public Integer getCodigoUsuarioResposta() {
		return codigoUsuarioResposta;
	}

	public void setCodigoUsuarioResposta(Integer codigoUsuarioResposta) {
		this.codigoUsuarioResposta = codigoUsuarioResposta;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public LocalDateTime getDataResposta() {
		return dataResposta;
	}

	public void setDataResposta(LocalDateTime dataResposta) {
		this.dataResposta = dataResposta;
	}
	
	

	public Integer getTipoComplemento() {
		return tipoComplemento;
	}

	public void setTipoComplemento(Integer tipoComplemento) {
		this.tipoComplemento = tipoComplemento;
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
