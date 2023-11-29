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

import br.com.omnisoftapi.converter.ProdutoConverter;
import br.com.omnisoftapi.domain.service.ServiceProduto;
import br.com.omnisoftapi.model.dto.ProdutoComSkuDTO;
import br.com.omnisoftapi.utils.TolowerCase;

@RequestMapping("produtosvariacoes")
@RestController
public class ControllerProduto {
	@Autowired
	private ProdutoConverter produtoConverter;
	@Autowired
	private ServiceProduto serviceProduto;

	@GetMapping
	public ResponseEntity<Page<ProdutoComSkuDTO>> listar(
			@RequestParam(value = "parametro", required = false, defaultValue = "") String parametro,
			@RequestParam(value = "page", defaultValue = "0") Integer pagina,
			@RequestParam(value = "size", defaultValue = "10") Integer size, Pageable page) {
		parametro = TolowerCase.normalizarString(parametro);
		return ResponseEntity.status(HttpStatus.OK)
				.body((produtoConverter.topage(serviceProduto.buscar(parametro, page))));
	}
}
