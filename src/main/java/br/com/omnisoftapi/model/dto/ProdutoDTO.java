package br.com.omnisoftapi.model.dto;

import java.math.BigDecimal;

import br.com.omnisoftapi.domain.enums.Medida;
import br.com.omnisoftapi.domain.enums.TipoProduto;
import lombok.Data;

@Data
public class ProdutoDTO {

	private Long id;
	private BigDecimal precovenda;
	private String nomeProduto;
	private String marcaProduto;
	private String codigoEan13;
	private Integer estoqueproduto;
	private TipoProduto tipoproduto;
	private Integer estoquetotal;
	private Medida medida;
	private String nomeSubgrupo;
}
