package com.example.api;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.api.model.Ingrediente;
import com.example.api.model.IngredienteEnum;
import com.example.api.model.LancheModel;
import com.example.api.service.PedidoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PedidoServiceTest {

	@Autowired
	private PedidoService service;
	
	@Test
	public void testRegraPrecoHamburguerQueijo() {
		
		LancheModel lanche = new LancheModel();
		
		List<Ingrediente> ingredientes = new ArrayList<>();
		
		Ingrediente bacon = new Ingrediente(IngredienteEnum.BACON, 1);
		Ingrediente hamburguer = new Ingrediente(IngredienteEnum.HAMBURGUERCARNE, 4);
		Ingrediente queijo = new Ingrediente(IngredienteEnum.QUEIJO, 4);
		
		ingredientes.add(bacon);
		ingredientes.add(hamburguer);
		ingredientes.add(queijo);
		
		lanche.setIngredientes(ingredientes);
		
		lanche = service.calculaValorLanche(lanche);
		
		assertEquals(new Double(20), lanche.getValorTotal());
	}
	
	@Test
	public void testRegraPrecoQueijo() {
		
		LancheModel lanche = new LancheModel();
		
		List<Ingrediente> ingredientes = new ArrayList<>();
		
		Ingrediente bacon = new Ingrediente(IngredienteEnum.BACON, 1);
		Ingrediente hamburguer = new Ingrediente(IngredienteEnum.HAMBURGUERCARNE, 1);
		Ingrediente queijo = new Ingrediente(IngredienteEnum.QUEIJO, 3);
		
		ingredientes.add(bacon);
		ingredientes.add(hamburguer);
		ingredientes.add(queijo);
		
		lanche.setIngredientes(ingredientes);
		
		lanche = service.calculaValorLanche(lanche);
		
		assertEquals(new Double(8), lanche.getValorTotal());
	}
	
	@Test
	public void testRegraPrecoHamburguer() {
		
		LancheModel lanche = new LancheModel();
		
		List<Ingrediente> ingredientes = new ArrayList<>();
		
		Ingrediente bacon = new Ingrediente(IngredienteEnum.BACON, 1);
		Ingrediente hamburguer = new Ingrediente(IngredienteEnum.HAMBURGUERCARNE, 4);
		Ingrediente queijo = new Ingrediente(IngredienteEnum.QUEIJO, 1);
		
		ingredientes.add(bacon);
		ingredientes.add(hamburguer);
		ingredientes.add(queijo);
		
		lanche.setIngredientes(ingredientes);
		
		lanche = service.calculaValorLanche(lanche);
		
		assertEquals(new Double(15.5), lanche.getValorTotal());
	}
	
	@Test
	public void testValorLancheXBacon() {
		LancheModel xegg = service.comprarLancheXBacon();
		assertEquals(new Double(6.5), xegg.getValorTotal());
	}
	
	@Test
	public void testValorLancheXBurguer() {
		LancheModel xegg = service.comprarLancheXBuguer();
		assertEquals(new Double(4.05), xegg.getValorTotal());
	}
	
	@Test
	public void testValorLancheXEgg() {
		LancheModel xegg = service.comprarLanchexEgg();
		assertEquals(new Double(4.77), xegg.getValorTotal());
	}
	
	@Test
	public void testValorLancheXEggBacon() {
		LancheModel xegg = service.comprarLanchexEggBacon();
		assertEquals(new Double(7.3), xegg.getValorTotal());
	}
}
