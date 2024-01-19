package br.com.omnisoftapi.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.omnisoftapi.domain.entity.Estoque;

public interface DaoEstoque extends JpaRepository<Estoque,Long> {

}
