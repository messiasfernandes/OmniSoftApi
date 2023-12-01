package br.com.omnisoftapi.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.omnisoftapi.domain.entity.Produto;

@Repository
public interface DaoProduto extends JpaRepository<Produto, Long> {

	@Query(value= "SELECT DISTINCT p FROM Produto p " +
		       "LEFT JOIN  p.proutos_skus ps " +
		       "LEFT JOIN  p.marcaProduto " +
		       "LEFT JOIN  p.subgrupo s " +
		       "LEFT JOIN  p.estoque e LEFT JOIN  ps.atributos " +
		       "WHERE p.codigoEan13 = :parametro OR ps.codigoEan13Sku = :parametro", 
		       countQuery = "SELECT cout(p) FROM Produto p " +
				       "LEFT JOIN  p.proutos_skus ps " +
				       "LEFT JOIN  p.marcaProduto " +
				       "LEFT JOIN  p.subgrupo s " +
				       "LEFT JOIN  p.estoque e " 
		       )
	Page<Produto> buscarPorEan(@Param("parametro") String parametro, Pageable pageable);

	@Query("SELECT DISTINCT p FROM Produto p " +
		       "LEFT JOIN FETCH p.proutos_skus ps " +
		       "LEFT JOIN FETCH p.marcaProduto " +
		       "LEFT JOIN FETCH p.subgrupo s " +
		       "LEFT JOIN FETCH p.estoque e " +
		       "WHERE p.id =:parametro") 
	Page<Produto> buscarporId( Long parametro, Pageable pageable);
	
	
	@Query("SELECT  p FROM Produto p " +
	       "LEFT JOIN FETCH p.proutos_skus ps " +
	       "LEFT JOIN FETCH p.marcaProduto " +
	       "LEFT JOIN FETCH  p.subgrupo s " +
	       "LEFT JOIN FETCH p.estoque e  " +
	       "WHERE p.nomeProduto LIKE %:parametro% OR p.subgrupo.nomeSubgrupo LIKE %:parametro% OR p.marcaProduto.nomeMarca LIKE %:parametro% " +
	       "ORDER BY p.nomeProduto")
	Page<Produto> search(@Param("parametro") String parametro, Pageable pageable);
	 
	 @Query(value = "   select p.id, p.nome_produto,p.customedio , p.codigo_ean13,p.marca_produto_id ,"
	 		+ " p.precocusto ,p.subgrupo_id  , p.precovenda, ps.qtde_por_sku  from produto p  left join produto_sku ps "
	 		+ "      on p.id = ps.produto_id  left join sub_grupo sg on sg.id = p.subgrupo_id "
	 		+ "left join marca_produto mp "
	 		+ "      on mp.id = p.marca_produto_id  "
	 		+ "WHERE p.nome_produto LIKE %:parametro% OR sg.nome_subgrupo LIKE %:parametro% OR mp.nome_marca LIKE %:parametro% "
	 		+ "		       ORDER BY p.nome_produto"
	 		 ,  nativeQuery = true)  
	 Page<Produto> listar(@Param("parametro") String parametro, Pageable pageable);
	 @Query("SELECT  p FROM Produto p " +
		       "LEFT JOIN FETCH p.proutos_skus ps    LEFT JOIN FETCH p.subgrupo LEFT JOIN FETCH p.marcaProduto  LEFT JOIN FETCH p.estoque"
		       )
	 List<Produto> buscatodos();
}
