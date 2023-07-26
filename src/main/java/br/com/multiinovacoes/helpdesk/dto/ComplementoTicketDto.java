package br.com.multiinovacoes.helpdesk.dto;

import java.io.Serializable;
import java.time.LocalDateTime;



public class ComplementoTicketDto implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6050576618708454220L;

	private Long id;
	
	private Long codigoTicket;

	private LocalDateTime data;

	private Long codigoUsuario;

	private String descricaoComplemento;

	private String descricaoResposta;

	private LocalDateTime dataResposta;

	private Integer codigoUsuarioResposta;
	
	private String descricaoUsuario;
	
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


	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
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

	public LocalDateTime getDataResposta() {
		return dataResposta;
	}

	public void setDataResposta(LocalDateTime dataResposta) {
		this.dataResposta = dataResposta;
	}

	public Integer getCodigoUsuarioResposta() {
		return codigoUsuarioResposta;
	}

	public void setCodigoUsuarioResposta(Integer codigoUsuarioResposta) {
		this.codigoUsuarioResposta = codigoUsuarioResposta;
	}
	

	public String getDescricaoUsuario() {
		return descricaoUsuario;
	}

	public void setDescricaoUsuario(String descricaoUsuario) {
		this.descricaoUsuario = descricaoUsuario;
	}

	public Integer getTipoComplemento() {
		return tipoComplemento;
	}

	public void setTipoComplemento(Integer tipoComplemento) {
		this.tipoComplemento = tipoComplemento;
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
		ComplementoTicketDto other = (ComplementoTicketDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

	
	

}
