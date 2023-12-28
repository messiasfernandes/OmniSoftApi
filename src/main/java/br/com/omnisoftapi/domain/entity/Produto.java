/**
 * 
 */
package br.com.omnisoftapi.domain.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.omnisoftapi.domain.enums.TipoProduto;
import br.com.omnisoftapi.utils.TolowerCase;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author messias
 *
 */
@Getter
@Setter
@Entity
public class Produto extends GeradorId {

	private static final long serialVersionUID = 1L;
	@Setter(value = AccessLevel.NONE)
	@NotNull
	@NotBlank
	@Column(length = 150, nullable = false)
	private String nomeProduto;
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn
	private MarcaProduto marcaProduto;

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = TolowerCase.normalizarString(nomeProduto);
	}

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

	@JsonIgnoreProperties(value = { "nomeSubgrupo" }, allowGetters = true)
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "subgrupo_id")
	private SubGrupo subgrupo;
	@Getter(value = AccessLevel.NONE)
	@Transient
	private Integer estoqueproduto;
	@Getter(value = AccessLevel.NONE)
	@Transient
	private Integer estoquetotal;
	@Column(length = 255)
	private String imagemPrincipal;
	@JsonIgnore
	@OneToOne(mappedBy = "produto", fetch = FetchType.LAZY)
	@JoinColumn(name = "produto_id")
	private Estoque estoque;
	@Setter(value = AccessLevel.NONE)
	@Column(length = 30)
	@Enumerated(EnumType.STRING)
	private TipoProduto tipoproduto;
	@Fetch(FetchMode.SUBSELECT)

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProdutoSku> proutos_skus = new ArrayList<>();

	public void setPrecocusto(BigDecimal precocusto) {
		this.precocusto = precocusto.setScale(3, RoundingMode.HALF_UP);

	}

	public void setCustomedio(BigDecimal customedio) {
		this.customedio = customedio.setScale(3, RoundingMode.HALF_UP);

	}

	public void setPrecovenda(BigDecimal precovenda) {
		this.precovenda = precovenda.setScale(3, RoundingMode.HALF_UP);

	}

	public Integer getEstoqueproduto() {
		if (estoque == null) {
			this.estoqueproduto = 0;
			System.out.println("arq" + this.estoqueproduto);

		} else {

			for (int i = 0; i < proutos_skus.size(); i++)

				this.estoqueproduto = estoque.getQuantidade() / proutos_skus.get(i).getMutiplicador();

		}

		return estoqueproduto;
	}

	public Integer getEstoquetotal() {
		if (estoque == null) {
			estoquetotal = 0;
		} else {
			estoquetotal = estoque.getQuantidade();
			System.out.println(estoquetotal);
		}

		return estoquetotal;
	}

	public void setTipoproduto(TipoProduto tipoproduto) {
		this.tipoproduto = tipoproduto;
	}
	
	
}
