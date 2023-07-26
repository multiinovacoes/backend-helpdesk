package br.com.multiinovacoes.helpdesk.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.multiinovacoes.helpdesk.dto.ComplementoTicketDto;
import br.com.multiinovacoes.helpdesk.dto.TicketDto;
import br.com.multiinovacoes.helpdesk.enums.StatusEnum;
import br.com.multiinovacoes.helpdesk.mapper.TicketMapper;
import br.com.multiinovacoes.helpdesk.model.Ticket;
import br.com.multiinovacoes.helpdesk.repository.TicketRepository;
import br.com.multiinovacoes.helpdesk.repository.UsuarioRepository;
import br.com.multiinovacoes.helpdesk.request.TicketRequest;

@Service
@Transactional
public class TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private AnexoService anexoService;
	
	@Autowired
	private ComplementoTicketService complementoTicketService;
	
	@Autowired
	private TicketMapper ticketMapper;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public TicketDto salvarTicket(TicketRequest ticketRequest) {
		TicketDto ticketDto = ticketMapper.fromTicketDto(ticketRequest);
		
		ticketDto.setId(ticketRepository.getMaxSequencialId()+1);
		ticketDto.setAnoTicketGerado(LocalDate.now().getYear());
		ticketDto.setNumeroTicket(ticketRepository.getMaxSequencialCodigoCliente(ticketRequest.getCodigoCliente()));
		ticketDto.setDataAbertura(LocalDateTime.now());
		
		ticketRepository.save(ticketMapper.toTicket(ticketDto));
		
		if (ticketRequest.getListaAnexoDto() != null) {
			anexoService.salvarArquivo(ticketRequest.getListaAnexoDto(), ticketDto.getId());
		}
		
		ticketDto.setListaAnexo(anexoService.getListaAnexos(ticketDto.getId()));
		
		return ticketDto;
	}
	
	public TicketDto finalizarTicket(TicketRequest ticketRequest) {
		TicketDto ticketDto = ticketMapper.fromTicketDto(ticketRequest);
		ticketDto.setDataFechamento(LocalDateTime.now());
		ticketDto.setStatus(StatusEnum.FINALIZADO.getCodigo());
		ticketRepository.save(ticketMapper.toTicket(ticketDto));
		return ticketDto;
	}
	
	public TicketDto editarTicket(Long codigo) {
		TicketDto ticketDto = ticketMapper.toDto(ticketRepository.findById(codigo).get());
		ticketDto.setListaAnexo(anexoService.getListaAnexos(ticketDto.getId()));
		ticketDto.setListaComplementoTicketDto(complementoTicketService.getListaComplementoTicket(ticketDto.getId()));
		return ticketDto;
	}
	
	public TicketDto atendimentoTicket(Long codigo) {
		Ticket ticket = ticketRepository.findById(codigo).get();
		if (ticket.getStatus().equals(StatusEnum.ABERTO.getCodigo())) {
			ticket.setStatus(StatusEnum.ATENDIMENTO.getCodigo());
			ticket.setDataInicioAnalise(LocalDateTime.now());
			ticketRepository.save(ticket);
		}

		TicketDto ticketDto = ticketMapper.toDto(ticket);
		
		ticketDto.setListaAnexo(anexoService.getListaAnexos(ticketDto.getId()));
		ticketDto.setListaComplementoTicketDto(complementoTicketService.getListaComplementoTicket(ticketDto.getId()));
		return ticketDto;
	}

	
	public List<TicketDto> listarTicket(Integer codigoCliente) {
		List<TicketDto> listaTicketDto = ticketMapper.fromResponseList(ticketRepository.findByCodigoClienteOrderByIdDesc(codigoCliente));
		List<TicketDto> novaLista = new ArrayList<>();
		for (TicketDto ticketDto : listaTicketDto) {
			ticketDto.setDescricaoUsuario(usuarioRepository.getById(ticketDto.getCodigoUsuario()).getNome());
			novaLista.add(ticketDto);
		}
		return novaLista;
	}

	public List<TicketDto> listarTicketStatus(Integer codigoCliente, Integer status) {
		List<TicketDto> listaTicketDto = new ArrayList<>();
		if (codigoCliente != 0) {
			listaTicketDto = ticketMapper.fromResponseList(ticketRepository.findByCodigoClienteAndStatusOrderByIdDesc(codigoCliente, status));
		}else {
			listaTicketDto = ticketMapper.fromResponseList(ticketRepository.findByStatusOrderByIdDesc(status));
		}
		List<TicketDto> novaLista = new ArrayList<>();
		for (TicketDto ticketDto : listaTicketDto) {
			ticketDto.setDescricaoUsuario(usuarioRepository.getById(ticketDto.getCodigoUsuario()).getNome());
			novaLista.add(ticketDto);
		}
		return novaLista;
	}

	public List<TicketDto> listarTodosTickets() {
		List<TicketDto> listaTicketDto = ticketMapper.fromResponseList(ticketRepository.findAll(Sort.by("dataAbertura").descending()));
		List<TicketDto> novaLista = new ArrayList<>();
		for (TicketDto ticketDto : listaTicketDto) {
			ticketDto.setDescricaoUsuario(usuarioRepository.getById(ticketDto.getCodigoUsuario()).getNome());
			novaLista.add(ticketDto);
		}
		return novaLista;
	}
	
	public void excluirTicket(Long codigo) {
		ticketRepository.deleteById(codigo);
	}		

}
