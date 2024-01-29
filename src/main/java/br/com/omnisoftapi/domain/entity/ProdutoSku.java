package br.com.omnisoftapi.domain.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProdutoSku extends GeradorId {

	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private Produto produto;
	@Column(length = 50, nullable = false, unique = true)
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
	private Set<Atributo> atributos = new HashSet<>();
	@Setter(value = AccessLevel.NONE)
	@Digits(integer = 9, fraction = 4)
    private BigDecimal precodeVenda= BigDecimal.ZERO;
	@Getter(value = AccessLevel.NONE)
	@Transient
    private BigDecimal valordeVenda;
	@Transient
	private String concatenar() {
	    StringBuilder strBuilder = new StringBuilder();

	    for (Atributo atributo : atributos) {
	        strBuilder.append(atributo.getTipo()).append(" : ").append(atributo.getValor()).append(" | ");
	    }

	    // Remove o último "| " se houver algum atributo
	    if (!atributos.isEmpty()) {
	        strBuilder.setLength(strBuilder.length() - 2);
	    }

	    return strBuilder.toString();
	}

	public String getCaracteristica() {
		if(concatenar().isEmpty()) {
			return "Sem caractericas";
		}else {
			return concatenar();
		}
		
	}

	public Integer getQtdeporSku() {
		if (qtdePorSku == null) {
			qtdePorSku = produto.getEstoque().getQuantidade() / mutiplicador;
		}

		return qtdePorSku;
	}
	public void setPrecodeVenda(BigDecimal precodeVanda) {
		if(precodeVanda==null) {
		this.precodeVenda= BigDecimal.ZERO;
		}else {
			this.precodeVenda = precodeVanda.setScale(3, RoundingMode.HALF_UP);
		}
		
	}
	
	public BigDecimal getValordeVenda() {
		if(precodeVenda==null) {
		valordeVenda= produto.getPrecovenda().multiply(new BigDecimal(mutiplicador)) ;
		}
		else {
			valordeVenda = precodeVenda;
		}
		System.out.println(valordeVenda);
		return valordeVenda;
	}
}
