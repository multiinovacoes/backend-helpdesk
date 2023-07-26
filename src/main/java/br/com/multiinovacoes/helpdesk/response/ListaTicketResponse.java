package br.com.multiinovacoes.helpdesk.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.multiinovacoes.helpdesk.dto.TicketDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude
@ApiModel("Lista Ticket Response")
public class ListaTicketResponse {
	
	@ApiModelProperty(value = "Lista de Ticket")
	private List<TicketDto> ticketDtoList;
	
	public ListaTicketResponse(List<TicketDto> ticketDtoList) {
		this.ticketDtoList = ticketDtoList;
	}

	public List<TicketDto> getTicketDtoList() {
		return ticketDtoList;
	}

	public void setTicketDtoList(List<TicketDto> ticketDtoList) {
		this.ticketDtoList = ticketDtoList;
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
