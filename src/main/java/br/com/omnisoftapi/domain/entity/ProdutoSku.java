package br.com.omnisoftapi.domain.entity;

import java.math.BigDecimal;

import br.com.omnisoftapi.domain.enums.Medida;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Digits;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ProdutoSku extends GeradorId {

	private static final long serialVersionUID = 1L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private ProdutoVariacao produtoVariacao;
	@Column(length = 20 , nullable = false, unique = true)
     private String sku;

	@Column
	private Integer mutiplicador;
	@Digits(integer = 9, fraction = 2)
	private BigDecimal desconto;
	@Column(length = 30)
	@Enumerated(EnumType.STRING)
	private Medida medida;
	@Getter(value = AccessLevel.NONE)
	@Transient
	private Integer estoqueproduto;
	@Getter(value = AccessLevel.NONE)
	@Transient
	private Integer estoquetotal;

	@Transient
	private Integer TotalestoqueProduto() {
		estoqueproduto = produtoVariacao.getEstoque().getQuantidade() / mutiplicador;
		return estoqueproduto;
	}

	public Integer getEstoqueproduto() {
		estoqueproduto = produtoVariacao.getEstoque().getQuantidade() / mutiplicador;
		return estoqueproduto;
	}

	public Integer getEstoquetotal() {
		estoquetotal = produtoVariacao.getEstoque().getQuantidade();
		System.out.println(estoquetotal);
		return estoquetotal;
	}

}
