package br.com.omnisoftapi.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.omnisoftapi.domain.entity.Produto;
import br.com.omnisoftapi.model.dto.ProdutoComSkuDTO;
import br.com.omnisoftapi.model.dto.ProdutoDTO;
import br.com.omnisoftapi.model.dto.ProdutoDetalheDTO;
import br.com.omnisoftapi.model.input.ProdutoInput;

@Component
public class ProdutoConverter {

	@Autowired
	private ModelMapper modelMapper;

	public ProdutoDTO toDto(Produto objeto) {

		return modelMapper.map(objeto, ProdutoDTO.class);
	}
	public ProdutoComSkuDTO toDto2(Produto objeto) {

		return modelMapper.map(objeto, ProdutoComSkuDTO.class);
	}

	public Produto toEntity(ProdutoInput objeto) {

	return modelMapper.map(objeto, Produto.class);
	}

	public List<ProdutoDTO> toCollectionDto(List<Produto> produtos) {
		return produtos.stream().map(this::toDto).collect(Collectors.toList());
	}
//
	public Page<ProdutoComSkuDTO> topage(Page<Produto> objetos) {

		return objetos.map(obj -> toDto2(obj));
	}
	
	public ProdutoDetalheDTO toDtoEdit(Produto objeto) {

		return modelMapper.map(objeto, ProdutoDetalheDTO.class);
	}
}
