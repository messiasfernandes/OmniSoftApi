package br.com.omnisoftapi.domain.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Digits;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProdutoVariacao extends GeradorId {


private static final long serialVersionUID = 1L;
	
	@Digits(integer = 9, fraction = 4)
	@Setter(value = AccessLevel.NONE)
	private BigDecimal precovenda;
	@Setter(value = AccessLevel.NONE)
	@Digits(integer = 9, fraction = 4)
	private BigDecimal precocusto;
	@Setter(value = AccessLevel.NONE)
	@Digits(integer = 9, fraction = 4)
	private BigDecimal customedio;
	@Column(length = 13)
	private String codigoEan13;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private Produto produto;
	@Column(length = 255)
	private String imagemPrincipal;
	@JsonIgnoreProperties(value = { "nomeSubgrupo" }, allowGetters = true)
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn
	private SubGrupo subgrupo;
	@Transient
	private String caracteristica;
	@OneToOne(mappedBy = "produtoVariacao", fetch = FetchType.LAZY)
	@JoinColumn
	private Estoque estoque;
	@Fetch(FetchMode.SUBSELECT)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produtoVariacao", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProdutoSku> proutos_skus = new ArrayList<>();
	@Fetch(FetchMode.SUBSELECT)
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "produto_atributos", joinColumns = @JoinColumn(name = "produtov_id"))
	@BatchSize(size = 10)
	private List<Atributo> atributos = new ArrayList<>();
	public void setPrecocusto(BigDecimal precocusto) {
		this.precocusto = precocusto.setScale(3, RoundingMode.HALF_UP);

	}

	public void setCustomedio(BigDecimal customedio) {
		this.customedio = customedio.setScale(3, RoundingMode.HALF_UP);

	}

	public void setPrecovenda(BigDecimal precovenda) {
		this.precovenda = precovenda.setScale(3, RoundingMode.HALF_UP);

	}
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


}
