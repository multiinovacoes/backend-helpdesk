package br.com.multiinovacoes.helpdesk.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.multiinovacoes.helpdesk.dto.AnexoDto;
import br.com.multiinovacoes.helpdesk.model.Anexo;

@Mapper(componentModel = "spring")
public interface AnexoMapper {
	
	
	List<AnexoDto> fromResponseList(List<Anexo> list);
	
	AnexoDto toDto(Anexo anexo);
	
	Anexo toAnexo(AnexoDto dto);


}
