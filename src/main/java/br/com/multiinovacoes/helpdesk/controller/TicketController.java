package br.com.multiinovacoes.helpdesk.controller;

import static br.com.multiinovacoes.helpdesk.controller.TicketController.TICKET;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.multiinovacoes.helpdesk.exception.NegocioException;
import br.com.multiinovacoes.helpdesk.request.TicketRequest;
import br.com.multiinovacoes.helpdesk.response.ListaTicketResponse;
import br.com.multiinovacoes.helpdesk.response.TicketResponse;
import br.com.multiinovacoes.helpdesk.service.TicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
@Api(value = "Ticket", produces = APPLICATION_JSON_VALUE)
@RestController
@RequestMapping(path = TICKET	)
public class TicketController {
	
	public static final String TICKET = "/ticket";
	public static final String LISTAR = "/listar";
	public static final String LISTAR_STATUS = "/listar-status";
	public static final String LISTAR_TODOS = "/listar-todos";
	public static final String PARAMETRO = "/{codigo}";
	public static final String ATENDIMENTO_TICKET = "/atendimento-ticket/{codigo}";
	public static final String FINALIZAR = "/finalizar";
	
	@Autowired
	TicketService ticketService;
	
	@ApiOperation(value = "Obter lista de tickets", nickname = LISTAR)
	@GetMapping(path = LISTAR, produces = APPLICATION_JSON_VALUE)
	public ListaTicketResponse getListaTickets(@RequestParam Integer codigoCliente) {
		return new ListaTicketResponse(ticketService.listarTicket(codigoCliente));
	}

	@ApiOperation(value = "Obter lista de tickets pelo status", nickname = LISTAR_STATUS)
	@GetMapping(path = LISTAR_STATUS, produces = APPLICATION_JSON_VALUE)
	public ListaTicketResponse getListaTicketsStatus(@RequestParam Integer codigoCliente, @RequestParam Integer status) {
		return new ListaTicketResponse(ticketService.listarTicketStatus(codigoCliente, status));
	}

	@ApiOperation(value = "Obter lista de todos os tickets", nickname = LISTAR_TODOS)
	@GetMapping(path = LISTAR_TODOS, produces = APPLICATION_JSON_VALUE)
	public ListaTicketResponse getListaTodosTickets() {
		return new ListaTicketResponse(ticketService.listarTodosTickets());
	}
	
	@ApiOperation(value = "Obter um ticket para edição", nickname = PARAMETRO)
	@GetMapping(path = PARAMETRO, produces = APPLICATION_JSON_VALUE)
	public TicketResponse getEditarTicket(@PathVariable Long codigo) {
		return new TicketResponse(ticketService.editarTicket(codigo));
	}

	@ApiOperation(value = "Obter um ticket para atendimento", nickname = ATENDIMENTO_TICKET)
	@GetMapping(path = ATENDIMENTO_TICKET, produces = APPLICATION_JSON_VALUE)
	public TicketResponse getAtendimentoTicket(@PathVariable Long codigo) {
		return new TicketResponse(ticketService.atendimentoTicket(codigo));
	}

	@ApiOperation(value = "Enviar um ticket", nickname = TICKET)
	@PostMapping(produces = APPLICATION_JSON_VALUE)
	public TicketResponse salvarTicket(@Valid @RequestBody TicketRequest ticketRequest) {
		try {
			return new TicketResponse(ticketService.salvarTicket(ticketRequest));
		}catch (Exception e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}
	
	@ApiOperation(value = "Finalizar um ticket", nickname = FINALIZAR)
	@PostMapping(path = FINALIZAR, produces = APPLICATION_JSON_VALUE)
	public TicketResponse finalizarTicket(@Valid @RequestBody TicketRequest ticketRequest) {
		try {
			return new TicketResponse(ticketService.finalizarTicket(ticketRequest));
		}catch (Exception e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}


	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Excluir uma assunto", nickname = PARAMETRO)
	@DeleteMapping(path = PARAMETRO, produces = APPLICATION_JSON_VALUE)
	public void excluirTicket(@PathVariable Long codigo) {
		ticketService.excluirTicket(codigo);
	}


}
