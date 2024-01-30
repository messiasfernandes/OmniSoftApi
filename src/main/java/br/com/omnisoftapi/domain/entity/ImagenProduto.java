package br.com.omnisoftapi.domain.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Embeddable
public class ImagenProduto {
    private String nomeArquivo;
    
    private String contentType;
    private long tamanho;
}
