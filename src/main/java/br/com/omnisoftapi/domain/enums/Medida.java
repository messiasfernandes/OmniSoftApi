package br.com.omnisoftapi.domain.enums;

public enum Medida {
	Unidade("Unidade"), Caixa("Caixa"), Fardo("Fardo");

	private String descricao;

	private Medida(String descricao) {
		this.descricao = descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
