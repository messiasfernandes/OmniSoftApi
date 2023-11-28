package br.com.omnisoftapi.model.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PrecoProdutoDTO {
		
	private BigDecimal precovenda;
	
	private BigDecimal precocusto;

	private BigDecimal customedio;
}
