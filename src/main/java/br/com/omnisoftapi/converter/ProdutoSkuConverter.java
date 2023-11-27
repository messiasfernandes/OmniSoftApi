package br.com.omnisoftapi.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;


import br.com.omnisoftapi.domain.entity.ProdutoSku;
import br.com.omnisoftapi.model.dto.ProdutoSkuDTO;


@Component
public class ProdutoSkuConverter {
	
	@Autowired
	private ModelMapper modelMapper;

	public ProdutoSkuDTO toDto(ProdutoSku objeto) {

		return modelMapper.map(objeto, ProdutoSkuDTO.class);
	}

//	public SubGrupo toEntity(SubGrupoInput objeto) {
//
//		return modelMapper.map(objeto, SubGrupo.class);
//	}

	public List<ProdutoSkuDTO> toCollectionDto(List<ProdutoSku> subgrupos) {
		return subgrupos.stream().map(this::toDto).collect(Collectors.toList());
	}

	public Page<ProdutoSkuDTO> topage(Page<ProdutoSku> objetos) {

		return objetos.map(obj -> toDto(obj));
	}

}
