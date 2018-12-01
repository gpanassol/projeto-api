package com.example.api.model;

public enum IngredienteEnum {

	ALFACE("alface", 0.40), 
	BACON("bacon", 2.00), 
	HAMBURGUERCARNE("hamburguerCarne", 3.00), 
	OVO("ovo", 0.80), 
	QUEIJO("queijo", 1.50);
	
	private String nome;
	private Double preco;
	
	private IngredienteEnum(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
