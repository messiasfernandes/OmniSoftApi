package br.com.omnisoftapi.domain.enums;

public enum TipoProduto {
	  Simples("Simples"),
	  Com_Variação("Varição"),
	  Kit("Kit"),
	  Matéria_Prima("Matéria Prima"),
	  Serviço("Serviço"),
	  Digital("Digital");
	  
		
		private String descricao;
		private TipoProduto(String descrica) {
			this.descricao= descrica;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
	  
	  
	  
	}