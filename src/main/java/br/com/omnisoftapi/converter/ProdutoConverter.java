package br.com.omnisoftapi.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.omnisoftapi.domain.entity.Produto;
import br.com.omnisoftapi.model.dto.ProdutoComSkuDTO;
import br.com.omnisoftapi.model.dto.ProdutoDetalheDTO;

@Component
public class ProdutoConverter {

	@Autowired
	private ModelMapper modelMapper;

	public ProdutoComSkuDTO toDto(Produto objeto) {

		return modelMapper.map(objeto, ProdutoComSkuDTO.class);
	}
//
//	public SubGrupo toEntity(SubGrupoInput objeto) {
//
//		return modelMapper.map(objeto, SubGrupo.class);
//	}
//
	public List<ProdutoComSkuDTO> toCollectionDto(List<Produto> produtos) {
		return produtos.stream().map(this::toDto).collect(Collectors.toList());
	}
//
	public Page<ProdutoComSkuDTO> topage(Page<Produto> objetos) {

		return objetos.map(obj -> toDto(obj));
	}
	
	public ProdutoDetalheDTO toDtoEdit(Produto objeto) {

		return modelMapper.map(objeto, ProdutoDetalheDTO.class);
	}
}
