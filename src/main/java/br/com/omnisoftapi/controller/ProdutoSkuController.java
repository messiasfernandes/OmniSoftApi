package br.com.omnisoftapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.omnisoftapi.converter.ProdutoSkuConverter;
import br.com.omnisoftapi.domain.dao.DaoProdutoSku;
import br.com.omnisoftapi.model.dto.ProdutoSkuDTO;
import br.com.omnisoftapi.utils.Normalizacao;

@RequestMapping("produtossku")
@RestController
public class ProdutoSkuController {
	@Autowired
   private ProdutoSkuConverter produtoSkuConverter;
	@Autowired
   private DaoProdutoSku daoProdutoSku;
	
	@GetMapping
	public ResponseEntity<Page<ProdutoSkuDTO>> listar(
			@RequestParam(value = "parametro", required = false, defaultValue = "") String parametro,
			@RequestParam(value = "page", defaultValue = "0") Integer pagina,
			@RequestParam(value = "size", defaultValue = "10") Integer size, Pageable page) {
		parametro= Normalizacao.normalizarNome(parametro);
		return ResponseEntity.status(HttpStatus.OK)
				.body(produtoSkuConverter.topage(daoProdutoSku.search(parametro, page)));
	}
}
