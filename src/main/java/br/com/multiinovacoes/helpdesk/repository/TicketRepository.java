package br.com.multiinovacoes.helpdesk.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.multiinovacoes.helpdesk.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
	
	public List<Ticket> findByCodigoClienteOrderByIdDesc(Integer codigoCliente);
	
	public List<Ticket> findByStatusOrderByIdDesc(Integer status);
	
	public List<Ticket> findByCodigoClienteAndStatusOrderByIdDesc(Integer codigoCliente, Integer status);
	
	public Optional<Ticket> findById(Long id);
	
	@Query("SELECT coalesce(max(t.id), 0) FROM Ticket t")
	public Long getMaxSequencialId();

	@Query("SELECT coalesce(max(t.id), 0) FROM Ticket t where t.codigoCliente = ?1")
	public Long getMaxSequencialCodigoCliente(Integer codigoCliente);
	
	
}
