package br.com.multiinovacoes.helpdesk.dto;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class ListaAnexoDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4313343368793462569L;
	
	@ApiModelProperty(value = "Id do ticket")
	private Long codigoTicket;

	private String stringBase64;
	
	private String nomeArquivo;
	
	private List<ListaAnexoDto> listaAnexoDto;

	public Long getCodigoTicket() {
		return codigoTicket;
	}

	public void setCodigoTicket(Long codigoTicket) {
		this.codigoTicket = codigoTicket;
	}

	public List<ListaAnexoDto> getListaAnexoDto() {
		return listaAnexoDto;
	}

	public void setListaAnexoDto(List<ListaAnexoDto> listaAnexoDto) {
		this.listaAnexoDto = listaAnexoDto;
	}

	public String getStringBase64() {
		return stringBase64;
	}

	public void setStringBase64(String stringBase64) {
		this.stringBase64 = stringBase64;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	
	

}
