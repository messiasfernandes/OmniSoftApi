package br.com.omnisoftapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.omnisoftapi.domain.dao.DaoSubGrupo;
import br.com.omnisoftapi.domain.entity.SubGrupo;
import br.com.omnisoftapi.domain.service.exeption.NegocioException;
import br.com.omnisoftapi.utils.ServiceFuncoes;
import br.com.omnisoftapi.utils.TolowerCase;
import jakarta.transaction.Transactional;

@Service
public class ServiceSubgrupo extends ServiceFuncoes implements ServiceModel<SubGrupo> {
	@Autowired
	private DaoSubGrupo daoSubGrupo;

	@Override
	public Page<SubGrupo> buscar(String nome, Pageable pageable) {
		Page<SubGrupo> page=null;
		nome= TolowerCase.normalizarString(nome);
	if(ehnumero(nome)) {
		System.out.println("passou aqui");
		Long id = Sonumero(nome);
		page= daoSubGrupo.pesquisarpoId(id, pageable);
	}else {
		 nome =TolowerCase.normalizarString(nome);

			page= daoSubGrupo.search(nome, pageable);
	}
       return page;
	}
	
	@Override
	public void excluir(Long codigo) {
		// TODO Auto-generated method stub

	}

	@Override
	public SubGrupo buccarporid(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public SubGrupo salvar(SubGrupo objeto) {
		var nome =  TolowerCase.normalizarString( objeto.getNomeSubgrupo());
		
		SubGrupo subGrupoExistente = daoSubGrupo.buscar(nome);
		if (subGrupoExistente != null && !subGrupoExistente.equals(objeto)) {
			throw new NegocioException("SubGrupo já cadastrada no banco de dados");
		}

		if (subGrupoExistente == null) {
			return daoSubGrupo.save(objeto);
		} else {
			return subGrupoExistente;
		}

	}

}
