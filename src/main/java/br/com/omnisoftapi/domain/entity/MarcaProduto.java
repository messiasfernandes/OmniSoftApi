package br.com.omnisoftapi.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
public class MarcaProduto  extends GeradorId{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	@Column(length = 60, nullable = false)
	private String nomeMarca;

}
