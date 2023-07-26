package br.com.multiinovacoes.helpdesk.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "ARQUIVO_ANEXO")
public class Anexo implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -808936296045014021L;

	@Id
	@Column(name = "CODIGO_ANEXO")
	private Long id;
	
	@Column(name = "CODIGO_TICKET")
	private Long codigoTicket;

	@Column(name = "NOME_ARQUIVO")
	private String nomeArquivo;
	
	@Column(name = "ORIGEM_ANEXO")
	private Integer origemAnexo;
	
	@Column(name = "DATA_ANEXO")
	private LocalDate dataAnexo;


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

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	
	public Integer getOrigemAnexo() {
		return origemAnexo;
	}

	public void setOrigemAnexo(Integer origemAnexo) {
		this.origemAnexo = origemAnexo;
	}

	public LocalDate getDataAnexo() {
		return dataAnexo;
	}

	public void setDataAnexo(LocalDate dataAnexo) {
		this.dataAnexo = dataAnexo;
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
		Anexo other = (Anexo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

	
	

}
