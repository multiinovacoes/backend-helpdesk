package br.com.multiinovacoes.helpdesk.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.multiinovacoes.helpdesk.dto.ComplementoTicketDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude
@ApiModel("Lista Complemento Ticket Response")
public class ListaComplementoTicketResponse {
	
	@ApiModelProperty(value = "Lista de Complemento Ticket")
	private List<ComplementoTicketDto> complementoTicketDtoList;

	public ListaComplementoTicketResponse(List<ComplementoTicketDto> complementoTicketDtoList) {
		super();
		this.complementoTicketDtoList = complementoTicketDtoList;
	}

	public List<ComplementoTicketDto> getComplementoTicketDtoList() {
		return complementoTicketDtoList;
	}

	public void setComplementoTicketDtoList(List<ComplementoTicketDto> complementoTicketDtoList) {
		this.complementoTicketDtoList = complementoTicketDtoList;
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
