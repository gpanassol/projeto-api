package com.example.api.model;

import java.util.ArrayList;
import java.util.List;

public class LanchesModel {

	private Double valorTotalCompra;
	private List<LancheModel> lanches = new ArrayList<>();
	
	public Double getValorTotalCompra() {
		return valorTotalCompra;
	}
	public List<LancheModel> getLanches() {
		return lanches;
	}
	public void setValorTotalCompra(Double valorTotalCompra) {
		this.valorTotalCompra = valorTotalCompra;
	}
	public void setLanches(List<LancheModel> lanches) {
		this.lanches = lanches;
	}
}
