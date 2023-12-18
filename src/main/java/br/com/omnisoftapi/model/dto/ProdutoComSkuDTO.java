package br.com.omnisoftapi.model.dto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import br.com.omnisoftapi.domain.enums.TipoProduto;
import lombok.Data;

@Data
public class ProdutoComSkuDTO {
	private Long id;
	private BigDecimal precovenda;
	private String nomeProduto;
	private String marcaProduto;
	private String codigoEan13;
	private Integer estoqueproduto;
	private TipoProduto tipoproduto;
	private Integer estoquetotal;

	private String nomeSubgrupo;
	// private ProdutoSkuDTO proutos_skus = new ProdutoSkuDTO();
	private Set<ProdutoSkuDTO> proutos_skus = new HashSet<>();

}
