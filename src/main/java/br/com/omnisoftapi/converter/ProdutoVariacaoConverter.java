package br.com.omnisoftapi.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.omnisoftapi.domain.entity.ProdutoVariacao;
import br.com.omnisoftapi.domain.entity.SubGrupo;
import br.com.omnisoftapi.model.dto.ProdutoVariacaoDTO;
import br.com.omnisoftapi.model.input.SubGrupoInput;

@Component
public class ProdutoVariacaoConverter {

	@Autowired
	private ModelMapper modelMapper;

	public ProdutoVariacaoDTO toDto(ProdutoVariacao objeto) {

		return modelMapper.map(objeto, ProdutoVariacaoDTO.class);
	}

	public SubGrupo toEntity(SubGrupoInput objeto) {

		return modelMapper.map(objeto, SubGrupo.class);
	}

	public List<ProdutoVariacaoDTO> toCollectionDto(List<ProdutoVariacao> produtosvariacao) {
		return produtosvariacao.stream().map(this::toDto).collect(Collectors.toList());
	}

	public Page<ProdutoVariacaoDTO> topage(Page<ProdutoVariacao> objetos) {

		return objetos.map(obj -> toDto(obj));
	}
}
