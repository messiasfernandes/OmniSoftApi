package br.com.omnisoftapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import br.com.omnisoftapi.domain.entity.ProdutoVariacao;
import br.com.omnisoftapi.utils.Normalizacao;
import br.com.omnisoftapi.utils.ServiceFuncoes;

@Service
public class ServiceProdutoVariacao extends ServiceFuncoes implements ServiceModel<ProdutoVariacao> {
//	@Autowired
	//private DaoProdutoVariacao daoProdutoVariacao;

	@Override
	public Page<ProdutoVariacao> buscar(String nome, Pageable pageable) {
//		Page<ProdutoVariacao> page = null;
//		if (!ehnumero(nome) && (qtdecaraceteres(nome) >= 0)) {
//			nome = Normalizacao.normalizarNome(nome);
//			page = daoProdutoVariacao.search(nome, pageable);
//		}
//		if ((ehnumero(nome)) && (qtdecaraceteres(nome) != 13)) {
//			Long id = Sonumero(nome);
//			page = daoProdutoVariacao.pesquisarpoId(id, pageable);
//		}
//		if ((ehnumero(nome)) && (qtdecaraceteres(nome) == 13)) {
//			page = daoProdutoVariacao.buscaporEan(nome, pageable);
//		}else {
//			page = daoProdutoVariacao.search(nome, pageable);
//		}
//		return page;
		return null;
	}

	@Override
	public void excluir(Long codigo) {
		// TODO Auto-generated method stub

	}

	@Override
	public ProdutoVariacao buccarporid(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProdutoVariacao salvar(ProdutoVariacao objeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
