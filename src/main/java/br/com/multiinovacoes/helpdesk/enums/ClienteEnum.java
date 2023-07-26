package br.com.multiinovacoes.helpdesk.enums;

import java.util.HashMap;
import java.util.Map;

public enum ClienteEnum {
	
	COLEGIO_TIMOTEO(1,"Colégio Católica Timóteo"),
	COLEGIO_UBEC(2, "UBEC"),
	COLEGIO_PADRE_MAN(3, "Colégio Padre de Man"),
	COLEGIO_BRASILIA(4, "Centro Educacional Católica de Brasília"),
	COLEGIO_UCB(5, "UCB"),
	COLEGIO_UNILESTE(6, "UNILESTE"),
	COLEGIO_FICR(7, "FICR"),
	COLEGIO_UNICATOLICA(8, "UNICATOLICA"),
	COLEGIO_CURITIBA(9, "Colégio Católica de Curitiba"),
	COLEGIO_JOINVILE(10, "Colégio Católica Joinville"),
	SENAI_PE(11, "SENAI - Sistema Fiepe"),
	SESC_PE(12, "SESC PERNAMBUCO"),
	HOSPITAL_BALBINO(13, "HOSPITAL BALBINO"),
	PREFEITURA_RECIFE(14, "PREFEITURA DO RECIFE");
	
	private Integer codigo;
	
	private String descricao;
	
	private static final Map<Integer, ClienteEnum> funcaoPegaDescricao = new HashMap<>();
	
	static {
		for (ClienteEnum statusEnum : ClienteEnum.values()) {
			funcaoPegaDescricao.put(statusEnum.getCodigo(), statusEnum);
		}
	}
	
	ClienteEnum(Integer codigo, String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static ClienteEnum pegarDescricao(Integer codigo) {
		return funcaoPegaDescricao.get(codigo);
	}
	

}
