package br.com.omnisoftapi.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.omnisoftapi.domain.entity.ProdutoMedida;
import br.com.omnisoftapi.model.dto.ProdutoMedidaDTO;

@Mapper(
	    componentModel = "spring"
	)
public interface IMapperDto{
	 IMapperDto INSTANCE = Mappers.getMapper(IMapperDto.class);
	ProdutoMedidaDTO toDTO(ProdutoMedida produtoMedida);
	List<ProdutoMedidaDTO>toListDto(List<ProdutoMedida>produtoMedidas);

}
