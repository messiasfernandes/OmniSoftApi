/**
 * 
 */
package br.com.omnisoftapi.domain.entity;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.omnisoftapi.utils.Normalizacao;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class Produto extends GeradorId{

	
	private static final long serialVersionUID = 1L;
	@Setter(value = AccessLevel.NONE)
	@NotNull
	@NotBlank
	@Column(length = 150, nullable = false)
	private String nomeProduto;
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn
	private MarcaProduto marcaProduto;

	@Fetch(FetchMode.SUBSELECT)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProdutoVariacao> proutos_varicaoes = new ArrayList<>();
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = Normalizacao.normalizarNome(nomeProduto);
	}
}
