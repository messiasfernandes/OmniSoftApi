package br.com.omnisoftapi.model.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.omnisoftapi.domain.enums.Medida;
import lombok.Data;
@JsonInclude(value = Include.NON_NULL)
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
