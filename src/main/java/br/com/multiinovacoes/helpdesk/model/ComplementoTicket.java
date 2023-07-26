package br.com.multiinovacoes.helpdesk.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "COMPLEMENTO_TICKET")
public class ComplementoTicket implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -808936296045014021L;

	@Id
	@Column(name = "CODIGO_COMPLEMENTO")
	private Long id;
	
	@Column(name = "CODIGO_TICKET")
	private Long codigoTicket;

	@Column(name = "DATA")
	private LocalDateTime data;

	@Column(name = "CODIGO_USUARIO")
	private Integer codigoUsuario;

	@Column(name = "DESCRICAO")
	private String descricaoComplemento;

	@Column(name = "RESPOSTA")
	private String descricaoResposta;

	@Column(name = "DATA_RESPOSTA")
	private LocalDateTime dataResposta;

	@Column(name = "CODIGO_USUARIO_RESPOSTA")
	private Integer codigoUsuarioResposta;
	
	@Column(name = "TIPO_COMPLEMENTO")
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

	public Integer getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Integer codigoUsuario) {
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
		ComplementoTicket other = (ComplementoTicket) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

	
	

}
