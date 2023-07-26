package br.com.multiinovacoes.helpdesk.enums;

import java.util.HashMap;
import java.util.Map;

public enum StatusEnum {
	
	ABERTO(1,"Aberto"),
	ATENDIMENTO(2, "Em atendimento"),
	AGUARDANDO_INFORMACOES(3, "Aguardando informações"),
	FINALIZADO(4, "Finalizado"),
	CANCELADO(5, "Cancelado");
	
	private Integer codigo;
	
	private String descricao;
	
	private static final Map<Integer, StatusEnum> funcaoPegaDescricao = new HashMap<>();
	
	static {
		for (StatusEnum statusEnum : StatusEnum.values()) {
			funcaoPegaDescricao.put(statusEnum.getCodigo(), statusEnum);
		}
	}
	
	StatusEnum(Integer codigo, String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static StatusEnum pegarDescricao(Integer codigo) {
		return funcaoPegaDescricao.get(codigo);
	}
	

}
