package br.com.multiinovacoes.helpdesk.response;

import br.com.multiinovacoes.helpdesk.dto.TicketDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Ticket Response")
public class TicketResponse {
	
	@ApiModelProperty(value = "Ticket Dto")
	private TicketDto ticketDto;
	
	public TicketResponse(TicketDto ticketDto) {
		this.ticketDto = ticketDto;
	}

	public TicketDto getTicketDto() {
		return ticketDto;
	}

	public void setTicketDto(TicketDto ticketDto) {
		this.ticketDto = ticketDto;
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
