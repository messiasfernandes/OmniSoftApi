package br.com.omnisoftapi.model.input;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.omnisoftapi.domain.entity.Estoque;
import br.com.omnisoftapi.domain.entity.MarcaProduto;
import br.com.omnisoftapi.domain.entity.ProdutoSku;
import br.com.omnisoftapi.domain.entity.SubGrupo;
import br.com.omnisoftapi.domain.enums.TipoProduto;
import br.com.omnisoftapi.utils.TolowerCase;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ProdutoInput {
	private Long id;
	private String nomeProduto;

	private MarcaProduto marcaProduto;

	@Column(length = 20)
	private String codigofabricante;

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = TolowerCase.normalizarString(nomeProduto);
	}

	private Estoque estoque;
	private BigDecimal precovenda;

	private BigDecimal precocusto;

	private BigDecimal customedio;

	private String codigoEan13;

	private SubGrupo subgrupo;

	private String imagemPrincipal;

	private TipoProduto tipoproduto;

	private List<ProdutoSku> proutos_skus = new ArrayList<>();

}
