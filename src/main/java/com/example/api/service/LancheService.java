package com.example.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.model.Ingrediente;
import com.example.api.model.IngredienteEnum;
import com.example.api.model.LancheModel;

@Service
public class LancheService {
	
	@Autowired
	private CompraService compraService;
	
	/**
	 * Lanche XBacon Padrão
	 * @return
	 */
	public LancheModel getXBacon() {
		
		LancheModel xbacon = new LancheModel();
		xbacon.setNome("X-Bacon");
		
		List<Ingrediente> ingredientes = new ArrayList<>();
		
		Ingrediente bacon = new Ingrediente(IngredienteEnum.BACON, 1);
		Ingrediente hamburguer = new Ingrediente(IngredienteEnum.HAMBURGUERCARNE, 1);
		Ingrediente queijo = new Ingrediente(IngredienteEnum.QUEIJO, 1);
		
		ingredientes.add(bacon);
		ingredientes.add(hamburguer);
		ingredientes.add(queijo);
		
		xbacon.setIngredientes(ingredientes);
		compraService.calculaValorLanche(xbacon);
		
		return xbacon;
	}
	
	/**
	 * Lanche XBurguer Padrão
	 * @return
	 */
	public LancheModel getxBuguer() {
		
		LancheModel xBuguer = new LancheModel();
		xBuguer.setNome("X-Burguer");
		
		List<Ingrediente> ingredientes = new ArrayList<>();
		
		Ingrediente hamburguer = new Ingrediente(IngredienteEnum.HAMBURGUERCARNE, 1);
		Ingrediente queijo = new Ingrediente(IngredienteEnum.QUEIJO, 1);
		
		ingredientes.add(hamburguer);
		ingredientes.add(queijo);
		
		xBuguer.setIngredientes(ingredientes);
		compraService.calculaValorLanche(xBuguer);
		
		return xBuguer;
	}
	
	/**
	 * Lanche xEgg Padrão
	 * @return
	 */
	public LancheModel getxEgg() {
		
		LancheModel xEgg = new LancheModel();
		xEgg.setNome("X-Egg");
		
		List<Ingrediente> ingredientes = new ArrayList<>();
		
		Ingrediente ovo = new Ingrediente(IngredienteEnum.OVO, 1);
		Ingrediente hamburguer = new Ingrediente(IngredienteEnum.HAMBURGUERCARNE, 1);
		Ingrediente queijo = new Ingrediente(IngredienteEnum.QUEIJO, 1);
		
		ingredientes.add(ovo);
		ingredientes.add(hamburguer);
		ingredientes.add(queijo);
		
		xEgg.setIngredientes(ingredientes);
		compraService.calculaValorLanche(xEgg);
		
		return xEgg;
	}
	
	/**
	 * Lanche xEggBacon Padrão
	 * @return
	 */
	public LancheModel getxEggBacon() {
		
		LancheModel xEggBacon = new LancheModel();
		xEggBacon.setNome("X-EggBacon");
		
		List<Ingrediente> ingredientes = new ArrayList<>();
		
		Ingrediente ovo = new Ingrediente(IngredienteEnum.OVO, 1);
		Ingrediente bacon = new Ingrediente(IngredienteEnum.BACON, 1);
		Ingrediente hamburguer = new Ingrediente(IngredienteEnum.HAMBURGUERCARNE, 1);
		Ingrediente queijo = new Ingrediente(IngredienteEnum.QUEIJO, 1);
		
		ingredientes.add(ovo);
		ingredientes.add(bacon);
		ingredientes.add(hamburguer);
		ingredientes.add(queijo);
		
		xEggBacon.setIngredientes(ingredientes);
		compraService.calculaValorLanche(xEggBacon);
		
		return xEggBacon;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<LancheModel> getTodosLanches() {
		
		List<LancheModel> retorno = new ArrayList<>();
		retorno.add(getXBacon());
		retorno.add(getxBuguer());
		retorno.add(getxEgg());
		retorno.add(getxEggBacon());
		
		return retorno;
	}
	
}
