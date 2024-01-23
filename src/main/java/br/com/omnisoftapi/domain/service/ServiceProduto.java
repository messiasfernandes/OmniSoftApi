package br.com.omnisoftapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.omnisoftapi.domain.dao.DaoEstoque;
import br.com.omnisoftapi.domain.dao.DaoProduto;
import br.com.omnisoftapi.domain.entity.Estoque;
import br.com.omnisoftapi.domain.entity.Produto;
import br.com.omnisoftapi.domain.service.exeption.RegistroNaoEncontrado;
import br.com.omnisoftapi.utils.GeradorSKU;
import br.com.omnisoftapi.utils.ServiceFuncoes;
import br.com.omnisoftapi.utils.TolowerCase;
import jakarta.transaction.Transactional;

@Service
public class ServiceProduto extends ServiceFuncoes implements ServiceModel<Produto> {
	@Autowired
	private DaoProduto daoProduto;
	@Autowired
	private DaoEstoque daoEstoque;

	@Override
	public Page<Produto> buscar(String nome, Pageable pageable) {
		Page<Produto> page = null;
		if (!ehnumero(nome) && (qtdecaraceteres(nome) >= 0)) {
			nome = TolowerCase.normalizarString(nome);
			page = daoProduto.search(nome, pageable);
		}
		if ((ehnumero(nome)) && (qtdecaraceteres(nome) != 13)) {
			Long id = Sonumero(nome);
			System.out.println("pasoo" + id);
			page = daoProduto.buscarporId(id, pageable);
		}
		if ((ehnumero(nome)) && (qtdecaraceteres(nome) == 13)) {
			page = daoProduto.buscarPorEan(nome, pageable);
		}

		return page;

	}

	@Override
	public void excluir(Long codigo) {
		// TODO Auto-generated method stub

	}

	@Transactional
	@Override
	public Produto salvar(Produto objeto) {
		  System.out.println("pasou no estoqu"+objeto.getEstoque().getId());
       if(objeto.getEstoque()== null &&  objeto.getEstoque().getId()==null){
    	 
    	   var estoque = new Estoque();
    	   estoque.setProduto(objeto);
    	   daoEstoque.save(estoque);
    	   
       }else {
    	   objeto.getEstoque().setProduto(objeto);
       }
		if (objeto.getProutos_skus().size() > 0) {
			objeto.getProutos_skus().forEach(p -> p.setProduto(objeto));

			for (int i = 0; i < objeto.getProutos_skus().size(); i++) {
				objeto.getProutos_skus().get(i).setSku(GeradorSKU.gerarSKU());

			}
		}
		return daoProduto.save(objeto);
	}


	@Override
	public Produto buccarporid(Long id) {

		if (daoProduto.findById(id).isEmpty()) {
			throw new RegistroNaoEncontrado("Produto não encotrada");
		}
		return daoProduto.findById(id).get();
	}

}
