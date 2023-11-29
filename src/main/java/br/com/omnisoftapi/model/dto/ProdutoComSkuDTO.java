package br.com.omnisoftapi.model.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ProdutoComSkuDTO {
	private Long id;
	private BigDecimal precovenda;
	private String nomeProduto;
	private String marcaProduto;
	private String codigoEan13;
	private Integer estoqueproduto;

	private Integer estoquetotal;
	//private Medida medida;
	private String nomeSubgrupo;
	//private ProdutoSkuDTO proutos_skus = new ProdutoSkuDTO();
	private List<ProdutoSkuDTO> proutos_skus = new ArrayList<>();
}
