package br.com.multiinovacoes.helpdesk.dto;

import java.time.LocalDate;

import io.swagger.annotations.ApiModelProperty;


public class AnexoDto  {

	@ApiModelProperty(value = "Id do anexo")	
	private Long id;
	
	@ApiModelProperty(value = "Código do Tícket")	
	private Long codigoTicket;
	
	@ApiModelProperty(value = "Nome do arquivo anexo")
	private String nomeArquivo;
	
	@ApiModelProperty(value = "Origem do arquivo anexo")
	private Integer origemAnexo;
	
	@ApiModelProperty(value = "Data do arquivo anexo")
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
		AnexoDto other = (AnexoDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
