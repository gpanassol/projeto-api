package com.example.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.api.model.Ingrediente;
import com.example.api.model.IngredienteEnum;
import com.example.api.model.LancheModel;

@Service
public class LancheService {
	
	/**
	 * Lanche XBacon Padrão
	 * @return
	 */
	public LancheModel getXBacon() {
		
		LancheModel xbacon = new LancheModel();
		
		List<Ingrediente> ingredientes = new ArrayList<>();
		
		Ingrediente bacon = new Ingrediente(IngredienteEnum.BACON, 1);
		Ingrediente hamburguer = new Ingrediente(IngredienteEnum.HAMBURGUERCARNE, 1);
		Ingrediente queijo = new Ingrediente(IngredienteEnum.QUEIJO, 1);
		
		ingredientes.add(bacon);
		ingredientes.add(hamburguer);
		ingredientes.add(queijo);
		
		xbacon.setIngredientes(ingredientes);
		
		return xbacon;
	}
	
	/**
	 * Lanche XBurguer Padrão
	 * @return
	 */
	public LancheModel getxBuguer() {
		
		LancheModel xBuguer = new LancheModel();
		
		List<Ingrediente> ingredientes = new ArrayList<>();
		
		Ingrediente hamburguer = new Ingrediente(IngredienteEnum.HAMBURGUERCARNE, 1);
		Ingrediente queijo = new Ingrediente(IngredienteEnum.QUEIJO, 1);
		
		ingredientes.add(hamburguer);
		ingredientes.add(queijo);
		
		xBuguer.setIngredientes(ingredientes);
		
		return xBuguer;
	}
	
	/**
	 * Lanche xEgg Padrão
	 * @return
	 */
	public LancheModel getxEgg() {
		
		LancheModel xEgg = new LancheModel();
		
		List<Ingrediente> ingredientes = new ArrayList<>();
		
		Ingrediente ovo = new Ingrediente(IngredienteEnum.OVO, 1);
		Ingrediente hamburguer = new Ingrediente(IngredienteEnum.HAMBURGUERCARNE, 1);
		Ingrediente queijo = new Ingrediente(IngredienteEnum.QUEIJO, 1);
		
		ingredientes.add(ovo);
		ingredientes.add(hamburguer);
		ingredientes.add(queijo);
		
		xEgg.setIngredientes(ingredientes);
		
		return xEgg;
	}
	
	/**
	 * Lanche xEggBacon Padrão
	 * @return
	 */
	public LancheModel getxEggBacon() {
		
		LancheModel xEggBacon = new LancheModel();
		
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
		
		return xEggBacon;
	}
	
	/**
	 * Monta lanche personalizado
	 * @param ingredientes
	 * @return
	 */
	public LancheModel getLanchePersonalizado(List<Ingrediente> ingredientes) {
		
		LancheModel personalizado = new LancheModel();
		
		if(ingredientes != null ) {
			personalizado.setIngredientes(ingredientes);
		}
		
		return personalizado;	
	}
	
	
	
}
