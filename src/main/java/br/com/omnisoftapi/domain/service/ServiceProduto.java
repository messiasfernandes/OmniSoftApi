package br.com.omnisoftapi.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.omnisoftapi.converter.ProdutoConverter;
import br.com.omnisoftapi.domain.dao.DaoProduto;
import br.com.omnisoftapi.domain.entity.Produto;
import br.com.omnisoftapi.model.dto.ProdutoComSkuDTO;
import br.com.omnisoftapi.utils.ServiceFuncoes;
import br.com.omnisoftapi.utils.TolowerCase;

@Service
public class ServiceProduto extends ServiceFuncoes implements ServiceModel<Produto> {
	@Autowired
	private DaoProduto daoProduto;
	@Autowired
  private ProdutoConverter produtoConverter;
	@Override
	public Page<Produto> buscar(String nome, Pageable pageable) {
		Page<Produto> page = null;
	if (!ehnumero(nome) && (qtdecaraceteres(nome) >= 0)) {
			nome = TolowerCase.normalizarString(nome);
     	page = daoProduto.search(nome, pageable);
		}
		if ((ehnumero(nome)) && (qtdecaraceteres(nome) != 13)) {
			Long id = Sonumero(nome);
			System.out.println("pasoo"+ id);
			page = daoProduto.buscarporId(id, pageable);
		}
		if ((ehnumero(nome)) && (qtdecaraceteres(nome) == 13)) {
			page = daoProduto.buscarPorEan(nome, pageable);
		}
	
		return page;
		
	}

	public List<ProdutoComSkuDTO >listar(){
		List<Produto> list= daoProduto.buscatodos( );
		return produtoConverter.toCollectionDto(list)  ;
	}

	@Override
	public void excluir(Long codigo) {
		// TODO Auto-generated method stub

	}



	@Override
	public Produto salvar(Produto objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto buccarporid(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
