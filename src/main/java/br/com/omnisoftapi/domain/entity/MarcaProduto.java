package br.com.omnisoftapi.domain.entity;

import br.com.omnisoftapi.utils.TolowerCase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class MarcaProduto extends GeradorId {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Setter(value = AccessLevel.NONE)
	@NotNull
	@Column(length = 60, nullable = false)
	private String nomeMarca;

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = TolowerCase.normalizarString(nomeMarca);
	}
}
