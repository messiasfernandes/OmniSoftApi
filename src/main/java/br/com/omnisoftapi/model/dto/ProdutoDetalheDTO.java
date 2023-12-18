package br.com.omnisoftapi.model.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.omnisoftapi.domain.entity.Estoque;
import br.com.omnisoftapi.domain.enums.TipoProduto;
import lombok.Data;
@Data
public class ProdutoDetalheDTO {
	

	private String nomeProduto;

	private MarcaProdutoDTO marcaProduto;



	private BigDecimal precovenda;
	
	
	private BigDecimal precocusto;


	private BigDecimal customedio;

	private String codigoEan13;


	private SubGrupoDTO subgrupo;


//	private Estoque estoque;



	private TipoProduto tipoproduto;



	private List<ProdutoSkuDTO> proutos_skus = new ArrayList<>();
}
