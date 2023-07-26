package br.com.multiinovacoes.helpdesk.request;

import java.io.Serializable;
import java.util.List;

import br.com.multiinovacoes.helpdesk.dto.ListaAnexoDto;
import io.swagger.annotations.ApiModelProperty;

public class ListaAnexoRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4313343368793462569L;
	
	@ApiModelProperty(value = "Id do atendimento")
	private Long codigoTicket;
	
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
	
	

}
