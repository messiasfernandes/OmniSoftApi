package br.com.omnisoftapi.domain.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.omnisoftapi.domain.enums.Medida;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
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
	private Produto produto;
	@Column(length = 20, nullable = false, unique = true)
	private String sku;
	@Column(length = 13)
	private String codigoEan13Sku;
	@Column(length = 255)
	private String imagemPrincipal;
	@Column
	private Integer mutiplicador;
	@Digits(integer = 9, fraction = 2)
	private BigDecimal desconto;
	@Column(length = 30)
	@Enumerated(EnumType.STRING)
	private Medida medida;
	@Getter(value = AccessLevel.NONE)
	private Integer qtdePorSku;
	@Transient
	private String caracteristica;
	@Fetch(FetchMode.SUBSELECT)
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "produto_atributos", joinColumns = @JoinColumn(name = "produtosku_id"))
	@BatchSize(size = 10)
	private List<Atributo> atributos = new ArrayList<>();
	@Setter(value = AccessLevel.NONE)
	@Digits(integer = 9, fraction = 4)
    private BigDecimal precodeVenda;
	@Getter(value = AccessLevel.NONE)
	@Transient
    private BigDecimal valordeVenda;
	@Transient
	private String concatenar() {
		StringBuilder strBuilder = new StringBuilder();
		var tam = atributos.size() - 1;

		for (int i = 0; i < atributos.size(); i++) {

			if (i == tam) {

				strBuilder.append(atributos.get(i).getTipo().concat(" : "));
				strBuilder.append(atributos.get(i).getValor().concat(" "));

			} else {

				strBuilder.append(atributos.get(i).getTipo().concat(" : "));
				strBuilder.append(atributos.get(i).getValor().concat(" | "));
			}

		}

		return strBuilder.toString();

	}

	public String getCaracteristica() {
		return concatenar();
	}

	public Integer getQtdeporSku() {
		if (qtdePorSku == null) {
			qtdePorSku = produto.getEstoque().getQuantidade() / mutiplicador;
		}

		return qtdePorSku;
	}
	public void setPrecodeVanda(BigDecimal precodeVanda) {
		this.precodeVenda = precodeVanda.setScale(3, RoundingMode.HALF_UP);
	}
	
	public BigDecimal getValordeVenda() {
		if(precodeVenda==null) {
			valordeVenda = produto.getPrecovenda().multiply(new BigDecimal(mutiplicador)) ;
		}
		else {
			valordeVenda = precodeVenda;
		}
		System.out.println(valordeVenda);
		return valordeVenda;
	}
}
