package br.com.omnisoftapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.omnisoftapi.api.ControlleProdutoOpenApi;
import br.com.omnisoftapi.converter.ProdutoConverter;
import br.com.omnisoftapi.domain.service.ServiceProduto;
import br.com.omnisoftapi.model.dto.CodigoBarraEANDTO;
import br.com.omnisoftapi.model.dto.ProdutoComSkuDTO;
import br.com.omnisoftapi.model.dto.ProdutoDTO;
import br.com.omnisoftapi.model.dto.ProdutoDetalheDTO;
import br.com.omnisoftapi.model.input.ProdutoInput;
import br.com.omnisoftapi.utils.TolowerCase;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RequestMapping("/produtos")
@RestController
public class ControllerProduto implements ControlleProdutoOpenApi {
	@Autowired
	private ProdutoConverter produtoConverter;
	@Autowired
	private ServiceProduto serviceProduto;

	@Override
	@GetMapping(produces = "application/json")
	public ResponseEntity<Page<ProdutoComSkuDTO>> listar(
			@RequestParam(value = "parametro", required = false, defaultValue = "") String parametro,
			@RequestParam(value = "page", defaultValue = "0") Integer pagina,
			@RequestParam(value = "size", defaultValue = "10") Integer size, Pageable page) {
		parametro = TolowerCase.normalizarString(parametro);
		return ResponseEntity.status(HttpStatus.OK)
				.body((produtoConverter.topage(serviceProduto.buscar(parametro, page))));
	}

	
	@GetMapping("{id}")
	@Override
	public ResponseEntity<ProdutoDetalheDTO> buscar(@PathVariable Long id) {

		return ResponseEntity.status(HttpStatus.OK).body(produtoConverter.toDtoEdit(serviceProduto.buccarporid(id)));
	}

	@PostMapping("/gerarean13")
	public ResponseEntity<CodigoBarraEANDTO> geararCodioEan13() {

		CodigoBarraEANDTO dto = new CodigoBarraEANDTO();
		dto.setEan13(serviceProduto.geraCodigoEan());
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}

	@PostMapping
	@Override
	public ResponseEntity<ProdutoDTO> criar(@Valid @RequestBody ProdutoInput produto, HttpServletResponse response) {
		System.out.println("pasou");
		var produtosalvao= serviceProduto.salvar(produtoConverter.toEntity(produto));
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoConverter.toDto(produtosalvao));
	}


	@PutMapping("/{id}")
	@Override
	public ResponseEntity<ProdutoDTO> Atualizar(@PathVariable Long id, @Valid @RequestBody ProdutoInput produto,
			HttpServletResponse response) {
		System.out.println(id);
		produto.setId(id);
		System.out.println(produto.getId());
		var produtoeditado = serviceProduto.salvar(produtoConverter.toEntity(produto));
		return ResponseEntity.status(HttpStatus.OK).body(produtoConverter.toDto(produtoeditado));
	}
}
