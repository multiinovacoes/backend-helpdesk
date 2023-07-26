package br.com.multiinovacoes.helpdesk.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.multiinovacoes.helpdesk.dto.TicketDto;
import br.com.multiinovacoes.helpdesk.model.Ticket;
import br.com.multiinovacoes.helpdesk.request.TicketRequest;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TicketMapper {
	   
	
	List<TicketDto> fromResponseList(List<Ticket> list);
	
	@Mapping(target = "descricaoCliente", ignore = true)
	@Mapping(target = "descricaoStatus", ignore = true)
	@Mapping(target = "listaAnexo", ignore = true)
	@Mapping(target = "listaComplementoTicketDto", ignore = true)
	TicketDto toDto(Ticket ticket);
	
	@Mapping(target = "descricaoCliente", ignore = true)
	@Mapping(target = "descricaoStatus", ignore = true)
	@Mapping(target = "listaAnexo", ignore = true)
	@Mapping(target = "listaComplementoTicketDto", ignore = true)
	TicketDto fromTicketDto(TicketRequest request);
	
	Ticket toTicket(TicketDto dto);


}
