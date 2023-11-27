package br.com.omnisoftapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.omnisoftapi.converter.ProdutoMedidaConverter;
import br.com.omnisoftapi.domain.dao.DaoProdutoMedida;
import br.com.omnisoftapi.mapper.IMapperDto;
import br.com.omnisoftapi.model.dto.ProdutoMedidaDTO;

@RestController
@RequestMapping("produtomedidas")
public class ControllerProdutoMedida {
	@Autowired
	private DaoProdutoMedida daoProdutoMedida;
	@Autowired
	private ProdutoMedidaConverter produtoMedidaConverter;

	@GetMapping
	public ResponseEntity<List<ProdutoMedidaDTO>> bucar(){
		return ResponseEntity.status(HttpStatus.OK).body(produtoMedidaConverter.toCollectionDto( daoProdutoMedida.buscar()));
	}

}
