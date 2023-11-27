/**
 * 
 */
package br.com.omnisoftapi.domain.entity;



import br.com.omnisoftapi.utils.Normalizacao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SubGrupo  extends GeradorId{

	private static final long serialVersionUID = 1L;
	@Setter(value = AccessLevel.NONE)
	@NotNull
	@NotBlank
	@Column(length = 45 , nullable = false)
	private String nomeSubgrupo;                                                                                                                                                                
	public void setNomeSubgrupo(String nomeSubgrupo) {
		this.nomeSubgrupo = Normalizacao.normalizarNome(nomeSubgrupo);
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Grupo grupo;

}
