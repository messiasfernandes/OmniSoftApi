package br.com.omnisoftapi.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Estoque extends GeradorId {

	private static final long serialVersionUID = 1L;
//  @JsonIgnore
	// @JsonBackReference
	@OneToOne(fetch = FetchType.LAZY)

	private ProdutoVariacao produtoVariacao;

	private Integer quantidade;

	public Estoque() {

		this.quantidade = 0;
	}

}
