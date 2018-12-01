package com.example.api.model;

public class Ingrediente {

	private String nome;
	private int qtd;
	private Double preco;
	
	public Ingrediente(IngredienteEnum ingrediente, int qtd){
       this.nome = ingrediente.getNome();
       this.preco = ingrediente.getPreco();
       this.qtd = qtd;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
