package com.example.api.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.model.Ingrediente;
import com.example.api.model.IngredienteEnum;
import com.example.api.model.LancheModel;
import com.example.api.model.LanchesModel;

@Service
public class CompraService {

	@Autowired
	private LancheService service;
	
	/**
	 * 
	 * @return
	 */
	public LancheModel comprarLancheXBacon() {
		
		LancheModel xbacon = service.getXBacon();
		xbacon = calculaValorLanche(xbacon);
		
		return xbacon;
	}
	
	/**
	 * 
	 * @return
	 */
	public LancheModel comprarLancheXBuguer() {
		
		LancheModel xburguer = service.getxBuguer();
		xburguer = calculaValorLanche(xburguer);
		
		return xburguer;
	}
	
	/**
	 * 
	 * @return
	 */
	public LancheModel comprarLanchexEgg() {
		
		LancheModel xEgg = service.getxEgg();
		xEgg = calculaValorLanche(xEgg);
		
		return xEgg;
	}
	
	/**
	 * 
	 * @return
	 */
	public LancheModel comprarLanchexEggBacon() {
		
		LancheModel xEggBacon = service.getxEggBacon();
		xEggBacon = calculaValorLanche(xEggBacon);
		
		return xEggBacon;
	}
	
	/**
	 * 
	 * @param ingredientes
	 * @return
	 */
	public LancheModel comprarLanchePersonalizado(List<Ingrediente> ingredientes) {
		
		LancheModel personalizado = new LancheModel();
		
		if(ingredientes != null ) {
			personalizado.setIngredientes(ingredientes);
		}
		
		personalizado = calculaValorLanche(personalizado);
		
		return personalizado;
	}
	
	/**
	 * Metodo retorna valor total de acordo com a lista de ingredientes
	 * @param ingredientes
	 * @return
	 */
	public LancheModel calculaValorLanche(LancheModel lanche) {
		
		double valorTotal = 0d;
		
		if(lanche != null && lanche.getIngredientes() != null) {
			for(Ingrediente ingrediente : lanche.getIngredientes()) {
				
				switch (ingrediente.getNome()) {
					case "alface":
						ingrediente.setPreco(IngredienteEnum.ALFACE.getPreco());
						valorTotal += IngredienteEnum.ALFACE.getPreco() * ingrediente.getQtd();
						break;
					case "bacon":
						ingrediente.setPreco(IngredienteEnum.BACON.getPreco());
						valorTotal += IngredienteEnum.BACON.getPreco() * ingrediente.getQtd();
						break;
					case "hamburguerCarne":
						ingrediente.setPreco(IngredienteEnum.HAMBURGUERCARNE.getPreco());
						valorTotal += IngredienteEnum.HAMBURGUERCARNE.getPreco() * ingrediente.getQtd();
						break;
					case "ovo":
						ingrediente.setPreco(IngredienteEnum.OVO.getPreco());
						valorTotal += IngredienteEnum.OVO.getPreco() * ingrediente.getQtd();
						break;
					case "queijo":
						ingrediente.setPreco(IngredienteEnum.QUEIJO.getPreco());
						valorTotal += IngredienteEnum.QUEIJO.getPreco() * ingrediente.getQtd();
						break;
						
					default:
						break;
				}
			}
		}
		
		lanche.setValorTotal(valorTotal);
		
		calculaPromocao(lanche);
		
		return lanche;
	}

	/**
	 * 
	 * @param lanche
	 * @return
	 */
	public LancheModel calculaPromocao(LancheModel lanche) {
		
		calculaPromocaoLight(lanche);
		calculaPromocaoMuitaCarne(lanche);
		calculaPromocaoMuitoQueijo(lanche);
		
		return lanche;
	}
	
	/**
	 * 
	 * @param lanche
	 * @return
	 */
	private LancheModel calculaPromocaoLight(LancheModel lanche) {
		
		double valorTotal = lanche.getValorTotal();
		boolean desconto = true;
		
		for(Ingrediente ingrediente : lanche.getIngredientes()) {
			if(ingrediente.getNome().equals(IngredienteEnum.BACON.getNome())) {
				desconto = false;
			}
		}
		
		if(desconto) {
			valorTotal -= valorTotal * 0.10;
		}
		
		lanche.setValorTotal(valorTotal);
		
		return lanche;
	}
	
	/**
	 * 
	 * @param lanche
	 * @return
	 */
	private LancheModel calculaPromocaoMuitaCarne(LancheModel lanche) {
		
		double vlLancheAtual = lanche.getValorTotal();
		
		int qtdDesconto = 0;
		int qtdCarne = 0;
		
		for(Ingrediente ingrediente : lanche.getIngredientes()) {
			if(ingrediente.getNome().equals(IngredienteEnum.HAMBURGUERCARNE.getNome())) {
				qtdCarne += ingrediente.getQtd();
			}
		}
		
		if(qtdCarne % 3 == 0) {
			qtdDesconto = qtdCarne / 3;
			vlLancheAtual -= qtdDesconto * IngredienteEnum.HAMBURGUERCARNE.getPreco();
		}
		
		lanche.setValorTotal(vlLancheAtual);
		
		return lanche;
	}

	/**
	 * 
	 * @param lanche
	 * @return
	 */
	private LancheModel calculaPromocaoMuitoQueijo(LancheModel lanche) {
		
		double vlLancheAtual = lanche.getValorTotal();
		
		int qtdDesconto = 0;
		int qtdQueijo = 0;
		
		
		for(Ingrediente ingrediente : lanche.getIngredientes()) {
			if(ingrediente.getNome().equals(IngredienteEnum.QUEIJO.getNome())) {
				qtdQueijo += ingrediente.getQtd();
			}
		}
		
		if(qtdQueijo % 3 == 0) {
			qtdDesconto = qtdQueijo / 3;
			vlLancheAtual -= qtdDesconto * IngredienteEnum.QUEIJO.getPreco();
		}
		
		lanche.setValorTotal(vlLancheAtual);
		
		return lanche;
	}

	/**
	 * 
	 * @param lanches
	 * @return
	 */
	public LanchesModel comprarLanches(@Valid LanchesModel lanches) {

		LanchesModel retorno = new LanchesModel();
		double valorTotalCompra = 0d;
		
		if(lanches != null) {
			for(LancheModel lanche : lanches.getLanches()) {
				LancheModel aux = this.comprarLanchePersonalizado(lanche.getIngredientes());
				valorTotalCompra += aux.getValorTotal();
				retorno.getLanches().add(aux);
			}
			
			retorno.setValorTotalCompra(valorTotalCompra);
		}
		
		return retorno;
	}
}
