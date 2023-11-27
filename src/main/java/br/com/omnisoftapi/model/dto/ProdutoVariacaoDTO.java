package br.com.omnisoftapi.model.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProdutoVariacaoDTO {
	
	private BigDecimal precovenda;
	private String nomeProduto;
	private String marcaProduto;

	//private Integer estoque;
//	private EstoqueDto estoque= new EstoqueDto();

}
