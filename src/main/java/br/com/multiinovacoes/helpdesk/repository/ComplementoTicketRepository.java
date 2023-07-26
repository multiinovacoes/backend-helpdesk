package br.com.multiinovacoes.helpdesk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.multiinovacoes.helpdesk.model.ComplementoTicket;


@Repository
public interface ComplementoTicketRepository extends JpaRepository<ComplementoTicket, Long> {
	
	public List<ComplementoTicket> findByCodigoTicket(Long codigoTicket);

	@Query("SELECT coalesce(max(c.id), 0) FROM ComplementoTicket c")
	public Long getMaxSequencialId();


}
