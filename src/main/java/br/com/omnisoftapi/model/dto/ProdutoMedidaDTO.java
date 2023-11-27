package br.com.omnisoftapi.model.dto;

import java.math.BigDecimal;

import br.com.omnisoftapi.domain.enums.Medida;
import lombok.Data;

@Data
public class ProdutoMedidaDTO {
	private ProdutoVariacaoDTO produtoVariacao = new ProdutoVariacaoDTO();

	private String codigoEAN13;

	private Integer mutiplicador;
	private Medida medida;
	private Integer estoqueproduto;
	private Integer estoquetotal;
}
