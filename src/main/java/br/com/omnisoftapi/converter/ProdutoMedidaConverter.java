package br.com.omnisoftapi.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.omnisoftapi.domain.entity.ProdutoMedida;
import br.com.omnisoftapi.model.dto.ProdutoMedidaDTO;

@Component
public class ProdutoMedidaConverter {
	
	@Autowired
	private ModelMapper modelMapper;

	public ProdutoMedidaDTO toDto(ProdutoMedida objeto) {

		return modelMapper.map(objeto, ProdutoMedidaDTO.class);
	}

//	public SubGrupo toEntity(SubGrupoInput objeto) {
//
//		return modelMapper.map(objeto, SubGrupo.class);
//	}

	public List<ProdutoMedidaDTO> toCollectionDto(List<ProdutoMedida> subgrupos) {
		return subgrupos.stream().map(this::toDto).collect(Collectors.toList());
	}

	public Page<ProdutoMedidaDTO> topage(Page<ProdutoMedida> objetos) {

		return objetos.map(obj -> toDto(obj));
	}

}
