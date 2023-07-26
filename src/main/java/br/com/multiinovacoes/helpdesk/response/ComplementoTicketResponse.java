package br.com.multiinovacoes.helpdesk.response;

import br.com.multiinovacoes.helpdesk.dto.ComplementoTicketDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Complemento Ticket Response")
public class ComplementoTicketResponse {
	
	@ApiModelProperty(value = "Complemento Ticket Dto")
	private ComplementoTicketDto complementoTicketDto;
	
	public ComplementoTicketResponse(ComplementoTicketDto complementoTicketDto) {
		this.complementoTicketDto = complementoTicketDto;
	}

	public ComplementoTicketDto getComplementoTicketDto() {
		return complementoTicketDto;
	}

	public void setComplementoTicketDto(ComplementoTicketDto complementoTicketDto) {
		this.complementoTicketDto = complementoTicketDto;
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
