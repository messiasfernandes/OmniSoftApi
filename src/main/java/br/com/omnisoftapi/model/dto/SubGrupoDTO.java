package br.com.omnisoftapi.model.dto;

import lombok.Data;

@Data
public class SubGrupoDTO {
	private GrupoDto  grupo = new GrupoDto();
	private Long id;
	private String nomeSubgrupo;

	

}
