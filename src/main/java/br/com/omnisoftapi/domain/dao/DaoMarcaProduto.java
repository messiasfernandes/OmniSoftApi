package br.com.omnisoftapi.domain.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.omnisoftapi.domain.entity.MarcaProduto;

public interface DaoMarcaProduto extends JpaRepository<MarcaProduto, Long> {
	@Query("SELECT DISTINCT m FROM MarcaProduto m  "

			+ " WHERE m.nomeMarca LIKE %:parametro% ORDER BY m.nomeMarca")

	Page<MarcaProduto> search(@Param("parametro") String parametro, Pageable pageable);
	
	@Query("from MarcaProduto m where m.nomeMarca = :nome")
	MarcaProduto buscar(String nome);

}
