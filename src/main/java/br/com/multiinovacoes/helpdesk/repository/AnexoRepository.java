package br.com.multiinovacoes.helpdesk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.multiinovacoes.helpdesk.model.Anexo;


@Repository
public interface AnexoRepository extends JpaRepository<Anexo, Long> {
	
	public List<Anexo> findByCodigoTicket(Long codigoTicket);

	@Query("SELECT coalesce(max(a.id), 0) FROM Anexo a")
	public Long getMaxSequencialId();


}
