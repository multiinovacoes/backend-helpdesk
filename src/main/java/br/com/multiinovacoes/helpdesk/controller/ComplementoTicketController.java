package br.com.multiinovacoes.helpdesk.controller;

import static br.com.multiinovacoes.helpdesk.controller.ComplementoTicketController.COMPLEMENTO_TICKET;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.multiinovacoes.helpdesk.request.ComplementoTicketRequest;
import br.com.multiinovacoes.helpdesk.response.ComplementoTicketResponse;
import br.com.multiinovacoes.helpdesk.response.ListaComplementoTicketResponse;
import br.com.multiinovacoes.helpdesk.service.ComplementoTicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
@Api(value = "Complemento Ticket", produces = APPLICATION_JSON_VALUE)
@RestController
@RequestMapping(path = COMPLEMENTO_TICKET	)
public class ComplementoTicketController {
	
	public static final String COMPLEMENTO_TICKET = "/complemento-ticket";
	public static final String RESPONDER_COMPLEMENTO_TICKET = "/responder-complemento-ticket";
	public static final String LISTAR = "/listar";
	public static final String PARAMETRO = "/{codigo}";
	
	
	@Autowired
	ComplementoTicketService complementoTicketService;
	
	@ApiOperation(value = "Obter lista de anexos", nickname = LISTAR)
	@GetMapping(path = LISTAR, produces = APPLICATION_JSON_VALUE)
	public ListaComplementoTicketResponse getListaComplementoTicket(Long codigoTicket) {
		return new ListaComplementoTicketResponse(complementoTicketService.getListaComplementoTicket(codigoTicket));
	}
	
	@ApiOperation(value = "Salva um complemento tícket")
	@PostMapping(produces = APPLICATION_JSON_VALUE)
	public ListaComplementoTicketResponse salvarComplementoTicket(@Valid @RequestBody ComplementoTicketRequest request) {
		complementoTicketService.salvarComplementoTicket(request);
		return new ListaComplementoTicketResponse(complementoTicketService.getListaComplementoTicket(request.getCodigoTicket()));
	}

	@ApiOperation(value = "Responder um complemento do tícket")
	@PostMapping(path = RESPONDER_COMPLEMENTO_TICKET, produces = APPLICATION_JSON_VALUE)
	public ListaComplementoTicketResponse responderComplementoTicket(@Valid @RequestBody ComplementoTicketRequest request) {
		complementoTicketService.responderComplementoTicket(request);
		return new ListaComplementoTicketResponse(complementoTicketService.getListaComplementoTicket(request.getCodigoTicket()));
	}

	@ApiOperation(value = "Obter um ticket para edição", nickname = PARAMETRO)
	@GetMapping(path = PARAMETRO, produces = APPLICATION_JSON_VALUE)
	public ComplementoTicketResponse getEditarTicket(@PathVariable Long codigo) {
		return new ComplementoTicketResponse(complementoTicketService.visualizarComplementoTicket(codigo));
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Excluir um complemento tícket", nickname = PARAMETRO)
	@DeleteMapping(path = PARAMETRO, produces = APPLICATION_JSON_VALUE)
	public void excluirComplementoTicket(@PathVariable Long codigo) {
		complementoTicketService.excluir(codigo);
	}


}
