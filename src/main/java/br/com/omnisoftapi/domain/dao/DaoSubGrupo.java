package br.com.omnisoftapi.domain.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.omnisoftapi.domain.entity.SubGrupo;
@Repository
public interface DaoSubGrupo extends JpaRepository<SubGrupo, Long> {
	@Query("SELECT DISTINCT s FROM SubGrupo s  "
			+ "LEFT JOIN FETCH s.grupo"
			+ " WHERE s.nomeSubgrupo LIKE %:parametro% "
			+ " OR  s.grupo.nomeGrupo LIKE  %:parametro% ")

	Page<SubGrupo> search(@Param("parametro") String parametro, Pageable pageable);

	@Query("from SubGrupo s where s.nomeSubgrupo = :nome")
	SubGrupo buscar(String nome);

	@Query("SELECT DISTINCT s FROM SubGrupo s LEFT JOIN FETCH s.grupo WHERE s.id = :parametro ")
	Page<SubGrupo> pesquisarpoId(@Param("parametro") Long parametro, Pageable pageable);
}
