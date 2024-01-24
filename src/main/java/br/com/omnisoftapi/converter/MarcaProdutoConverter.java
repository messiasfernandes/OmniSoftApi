package br.com.omnisoftapi.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.omnisoftapi.domain.entity.MarcaProduto;
import br.com.omnisoftapi.model.dto.MarcaProdutoDTO;
import br.com.omnisoftapi.model.input.MarcaProdutoInput;

@Component
public class MarcaProdutoConverter {
	
	@Autowired
	private ModelMapper modelMapper;

	public MarcaProdutoDTO toDto(MarcaProduto objeto) {

		return modelMapper.map(objeto, MarcaProdutoDTO.class);
	}

	public MarcaProduto toEntity(MarcaProdutoInput objeto) {

		return modelMapper.map(objeto, MarcaProduto.class);
	}

	public List<MarcaProdutoDTO> toCollectionDto(List<MarcaProduto> subgrupos) {
		return subgrupos.stream().map(this::toDto).collect(Collectors.toList());
	}

	public Page<MarcaProdutoDTO> topage(Page<MarcaProduto> objetos) {

		return objetos.map(obj -> toDto(obj));
	}


}
