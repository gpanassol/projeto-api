package com.example.api.model;

import java.util.ArrayList;
import java.util.List;

public class LancheModel {

	private Double valorTotal;
	private List<Ingrediente> ingredientes = new ArrayList<>();
	
	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
}
