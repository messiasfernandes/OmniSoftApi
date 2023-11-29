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

import br.com.omnisoftapi.converter.ProdutoVariacaoConverter;
import br.com.omnisoftapi.domain.service.ServiceProdutoVariacao;


@RequestMapping("produtosvariacoes")
@RestController
public class ControllerProdutoVariacao {
//	@Autowired
//	private ProdutoVariacaoConverter produtoVariacaoConverter;
//	@Autowired
//    private ServiceProdutoVariacao serviceProdutoVariacao;
//	@GetMapping
//	public ResponseEntity<Page<ProdutoVariacaoDTO>> listar(
//			@RequestParam(value = "parametro", required = false, defaultValue = "") String parametro,
//			@RequestParam(value = "page", defaultValue = "0") Integer pagina,
//			@RequestParam(value = "size", defaultValue = "10") Integer size, Pageable page) {
//	;
//		return null;
//			//	ResponseEntity.status(HttpStatus.OK)
//			//	.body(produtoVariacaoConverter.topage(serviceProdutoVariacao.buscar(parametro, page)));
//	}
}
