package br.com.omnisoftapi.model.input;

import lombok.Data;

@Data

public class SubGrupoInput {
	private Long id;

	private String nomeSubgrupo;                                                                                                                                                                
	
    private GrupoInput grupo= new GrupoInput();


}
