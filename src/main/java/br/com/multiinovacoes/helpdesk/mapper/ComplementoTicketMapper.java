package br.com.multiinovacoes.helpdesk.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.multiinovacoes.helpdesk.dto.ComplementoTicketDto;
import br.com.multiinovacoes.helpdesk.model.ComplementoTicket;
import br.com.multiinovacoes.helpdesk.request.ComplementoTicketRequest;

@Mapper(componentModel = "spring")
public interface ComplementoTicketMapper {
	
	
	List<ComplementoTicketDto> fromResponseList(List<ComplementoTicket> list);
	
	ComplementoTicketDto toDto(ComplementoTicket complementoTicket);
	
	ComplementoTicket toComplementoTicket(ComplementoTicketDto dto);
	
	ComplementoTicket fromComplementoTicket(ComplementoTicketRequest request);


}
