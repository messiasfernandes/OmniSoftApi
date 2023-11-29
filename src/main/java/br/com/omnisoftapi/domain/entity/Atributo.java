package br.com.omnisoftapi.domain.entity;



import br.com.omnisoftapi.utils.TolowerCase;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author messias
 *
 */
@Getter
@Setter
@Embeddable
public class Atributo {

	@Setter(value = AccessLevel.NONE)
	@Column(length = 60)
	private String tipo;
	@Setter(value = AccessLevel.NONE)

	@Column(length = 60)
	private String valor;

	public void setTipo(String tipo) {
		this.tipo = TolowerCase.normalizarString(tipo);
	}

	public void setValor(String valor) {
		this.valor = TolowerCase.normalizarString(valor);
	}

}
