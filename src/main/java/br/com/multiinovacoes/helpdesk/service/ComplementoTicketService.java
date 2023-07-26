package br.com.multiinovacoes.helpdesk.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.multiinovacoes.helpdesk.dto.ComplementoTicketDto;
import br.com.multiinovacoes.helpdesk.mapper.ComplementoTicketMapper;
import br.com.multiinovacoes.helpdesk.model.ComplementoTicket;
import br.com.multiinovacoes.helpdesk.model.Ticket;
import br.com.multiinovacoes.helpdesk.repository.ComplementoTicketRepository;
import br.com.multiinovacoes.helpdesk.repository.TicketRepository;
import br.com.multiinovacoes.helpdesk.repository.UsuarioRepository;
import br.com.multiinovacoes.helpdesk.request.ComplementoTicketRequest;

@Service
@Transactional
public class ComplementoTicketService {
	
	@Autowired
	ComplementoTicketRepository complementoTicketRepository;
	
	@Autowired
	ComplementoTicketMapper complementoTicketMapper;
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	

	public List<ComplementoTicketDto> getListaComplementoTicket(Long codigoTicket){
		List<ComplementoTicketDto> lista = complementoTicketMapper.fromResponseList(Optional.ofNullable(complementoTicketRepository.findByCodigoTicket(codigoTicket)).orElse(Collections.emptyList()));
		List<ComplementoTicketDto> novaLista = new ArrayList<>();
		for (ComplementoTicketDto complementoTicketDto : lista) {
			complementoTicketDto.setDescricaoUsuario(usuarioRepository.getById(complementoTicketDto.getCodigoUsuario()).getNome());
			novaLista.add(complementoTicketDto);
		}
		return novaLista;
	}
	
	public ComplementoTicketDto visualizarComplementoTicket(Long codigo) {
		ComplementoTicketDto complementoTicketDto = complementoTicketMapper.toDto(complementoTicketRepository.findById(codigo).get());
		return complementoTicketDto;
	}
	
	@Transactional
	public void salvarComplementoTicket(ComplementoTicketRequest complementoTicketRequest){
		ComplementoTicket complementoTicket = complementoTicketMapper.fromComplementoTicket(complementoTicketRequest);
		complementoTicket.setData(LocalDateTime.now());
		complementoTicket.setId(complementoTicketRepository.getMaxSequencialId()+1);
		complementoTicketRepository.save(complementoTicket);
		
		Ticket ticket = ticketRepository.getById(complementoTicket.getCodigoTicket());
		ticket.setStatus(3);
		ticketRepository.save(ticket);
	}
	
	
	@Transactional
	public void responderComplementoTicket(ComplementoTicketRequest complementoTicketRequest){
		ComplementoTicket complementoTicket = complementoTicketMapper.fromComplementoTicket(complementoTicketRequest);
		complementoTicket.setDataResposta(LocalDateTime.now());
		complementoTicketRepository.save(complementoTicket);
		
		Ticket ticket = ticketRepository.getById(complementoTicket.getCodigoTicket());
		ticket.setStatus(2);
		ticketRepository.save(ticket);
	}
	
	@Transactional
	public void excluir(Long codigoComplemento) {
		ComplementoTicket complementoTicket = complementoTicketRepository.getById(codigoComplemento);
		complementoTicketRepository.deleteById(codigoComplemento);
		Ticket ticket = ticketRepository.getById(complementoTicket.getCodigoTicket());
		ticket.setStatus(2);
		ticketRepository.save(ticket);
	}


}
