package br.com.omnisoftapi.domain.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.omnisoftapi.domain.entity.ProdutoSku;

public interface DaoProdutoSku extends JpaRepository<ProdutoSku, Long> {
	@Query("SELECT DISTINCT ps FROM ProdutoSku ps " + "LEFT JOIN FETCH ps.produto p "
			+ "LEFT JOIN FETCH p.marcaProduto " + "LEFT JOIN FETCH p.subgrupo s LEFT JOIN p.estoque e "
			+ "WHERE p.nomeProduto LIKE %:parametro% OR p.subgrupo.nomeSubgrupo LIKE %:parametro% OR p.marcaProduto.nomeMarca LIKE %:parametro% "
			+ "ORDER BY p.nomeProduto")
Page<ProdutoSku> search(@Param("parametro") String parametro, Pageable pageable);
}
