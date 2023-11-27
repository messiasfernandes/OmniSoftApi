package br.com.omnisoftapi.domain.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.omnisoftapi.domain.entity.ProdutoMedida;

public interface DaoProdutoMedida extends JpaRepository<ProdutoMedida, Long> {
	@Query("SELECT pm FROM ProdutoMedida pm left JOIN FETCH "
			+ "pm.produtoVariacao pv  "
			+ " left  JOIN FETCH pv.produto p  left  JOIN FETCH pv.estoque ")
		
	List<ProdutoMedida> buscar();
}

//	@Query("SELECT DISTINCT s FROM SubGrupo s LEFT JOIN FETCH s.grupo WHERE s.id = :parametro ")