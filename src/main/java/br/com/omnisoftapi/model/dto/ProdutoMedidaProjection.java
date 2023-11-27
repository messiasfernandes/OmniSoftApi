package br.com.omnisoftapi.model.dto;

import java.math.BigDecimal;

public interface ProdutoMedidaProjection {
	String getNomeProduto();
    BigDecimal getPrecoVenda();
    String getCodigoEAN13();
    int getEstoque();
    BigDecimal getVenda();
    BigDecimal getMultiplicador();
    String getMedida();

}
