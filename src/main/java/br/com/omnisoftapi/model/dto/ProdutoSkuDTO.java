package br.com.omnisoftapi.model.dto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import br.com.omnisoftapi.domain.entity.Atributo;
import br.com.omnisoftapi.domain.entity.ImagenProduto;
import br.com.omnisoftapi.domain.enums.Medida;
import lombok.Data;

@Data
public class ProdutoSkuDTO {

//private ProdutoDTo produto = new ProdutoDTo();
	private Long id;
	// private String nomeProduto;
	private BigDecimal precodeVenda;
	private String codigoEan13Sku;
	private BigDecimal valordeVenda;
	private Integer mutiplicador;
	private Medida medida;
	private Integer qtdePorSku;
	private String sku;
	private String caracteristica;

	private EstoqueDto estoque;
	private Set<Atributo> atributos = new HashSet<>();
	private Set<ImagenProduto> imagens = new HashSet<>();
	

}
