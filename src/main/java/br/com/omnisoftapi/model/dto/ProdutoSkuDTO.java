package br.com.omnisoftapi.model.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.omnisoftapi.domain.enums.Medida;
import lombok.Data;

@Data
public class ProdutoSkuDTO {
	
	private ProdutoDTo produto = new ProdutoDTo();
	private Long id;
	//private String nomeProduto;
	//private String codigoEan13;
	private String codigoEan13Sku;
	private BigDecimal valordeVenda;
	private Integer mutiplicador;
	private Medida medida;
    private Integer qtdeporSku;
	private String caracteristica;
	///private PrecoProdutoDTO precoproduto = new PrecoProdutoDTO();
	
}
