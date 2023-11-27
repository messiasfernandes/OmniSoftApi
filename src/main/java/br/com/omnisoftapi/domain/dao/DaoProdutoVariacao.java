package br.com.omnisoftapi.domain.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.omnisoftapi.domain.entity.ProdutoVariacao;

public interface DaoProdutoVariacao extends JpaRepository<ProdutoVariacao, Long> {
	@Query("SELECT DISTINCT pv FROM ProdutoVariacao pv " + "LEFT JOIN FETCH pv.produto p  "
			+ "LEFT JOIN FETCH p.marcaProduto " + "LEFT JOIN FETCH pv.subgrupo "
			+ "WHERE p.nomeProduto LIKE %:parametro% OR pv.subgrupo.nomeSubgrupo LIKE %:parametro% OR p.marcaProduto.nomeMarca LIKE %:parametro% "
			+ "ORDER BY p.nomeProduto")
	Page<ProdutoVariacao> search(@Param("parametro") String parametro, Pageable pageable);

	@Query("SELECT DISTINCT pv FROM ProdutoVariacao pv "
	        + "LEFT JOIN FETCH pv.produto p "
			+ "LEFT JOIN FETCH p.marcaProduto " 
	        + "LEFT JOIN FETCH pv.subgrupo " 
			+ "WHERE pv.id= :parametro ")
	Page<ProdutoVariacao> pesquisarpoId(@Param("parametro") Long parametro, Pageable pageable);

	@Query("SELECT DISTINCT pv " +
		       "FROM ProdutoVariacao pv " +
		       "LEFT JOIN FETCH pv.produto p " +
		       "LEFT JOIN FETCH p.marcaProduto " +
		       "LEFT JOIN FETCH pv.subgrupo " +
		       "WHERE pv.codigoEan13 = :parametro")
		Page<ProdutoVariacao> buscaporEan(@Param("parametro") String parametro, Pageable pageable);

}
