package br.com.projetoMvc.model;

public class Produto {

	private int id;
	private String descricao;
	
	//construtor vazio
	
	public Produto (){
		
	}
	//contrutor com paramentos
	public Produto (int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	// get e set
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}