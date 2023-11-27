package br.com.omnisoftapi.model.dto;

import java.math.BigDecimal;

import br.com.omnisoftapi.domain.enums.Medida;
import lombok.Data;

@Data
public class ProdutoVariacaoDTO {
	private Long id;
	private BigDecimal precovenda;
	private String nomeProduto;
	private String marcaProduto;
	private String codigoEan13;
	private Integer estoqueproduto;

	private Integer estoquetotal;
	private Medida medida;
	private String nomeSubgrupo;
	//private Integer estoque;
//	private EstoqueDto estoque= new EstoqueDto();
	

}
