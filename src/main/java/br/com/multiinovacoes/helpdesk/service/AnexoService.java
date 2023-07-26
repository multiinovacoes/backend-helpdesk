package br.com.multiinovacoes.helpdesk.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.multiinovacoes.helpdesk.dto.AnexoDto;
import br.com.multiinovacoes.helpdesk.dto.ListaAnexoDto;
import br.com.multiinovacoes.helpdesk.mapper.AnexoMapper;
import br.com.multiinovacoes.helpdesk.model.Anexo;
import br.com.multiinovacoes.helpdesk.repository.AnexoRepository;

@Service
@Transactional
public class AnexoService {
	
	@Autowired
	AnexoRepository anexoRepository;
	
	@Autowired
	AnexoMapper anexoMapper;
	

	public List<AnexoDto> getListaAnexos(Long codigoTicket){
		return anexoMapper.fromResponseList(Optional.ofNullable(anexoRepository.findByCodigoTicket(codigoTicket)).orElse(Collections.emptyList()));
	}
	
	@Transactional
	public void salvarArquivo(List<ListaAnexoDto> lista, Long codigoTicket){
		try {
			for (ListaAnexoDto listaAnexoDto : lista) {
		    	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		    	String nomeArq = timeStamp + "_" + listaAnexoDto.getNomeArquivo();
		    	byte[] anexo2 = Base64.decodeBase64(listaAnexoDto.getStringBase64().split(",")[1]);
				OutputStream out = new FileOutputStream(
						"C:\\gcon_arquivos\\arquivos\\helpdesk\\"+nomeArq); 
				out.write(anexo2);
				out.close();			    	
		    	
				Anexo anexo = new Anexo();
				anexo.setCodigoTicket(codigoTicket);
				anexo.setDataAnexo(LocalDate.now());
				anexo.setNomeArquivo(nomeArq);
				anexo.setOrigemAnexo(0);
				anexo.setId(anexoRepository.getMaxSequencialId()+1);
				anexoRepository.save(anexo);
			}
		}catch (IOException e) {
			e.getCause();
		}
	}
	
	public void excluir(Long codigoAnexo) {
		anexoRepository.deleteById(codigoAnexo);
	}


}
