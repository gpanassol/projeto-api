package com.example.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.LancheModel;
import com.example.api.model.LanchesModel;
import com.example.api.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	PedidoService service;
	
    @GetMapping("/xbacon")
    @ResponseBody
    public ResponseEntity<Object> getXBacon(){
        return ResponseEntity.ok().body(service.comprarLancheXBacon());
    }

    @GetMapping("/xburguer")
    @ResponseBody
    public ResponseEntity<Object> getXBuguer(){
        return ResponseEntity.ok().body(service.comprarLancheXBuguer());
    }
    
    @GetMapping("/xegg")
    @ResponseBody
    public ResponseEntity<Object> getXEgg(){
        return ResponseEntity.ok().body(service.comprarLanchexEgg());
    }
    
    @GetMapping("/xeggbacon")
    @ResponseBody
    public ResponseEntity<Object> getXEggBacon(){
        return ResponseEntity.ok().body(service.comprarLanchexEggBacon());
    }
    
    @PostMapping("/personalizado")
    public ResponseEntity<Object> getPersonalizado(@Valid @RequestBody LancheModel lanche){
    	return ResponseEntity.ok().body(service.comprarLanchePersonalizado(lanche.getIngredientes()));
    }
	
    @PostMapping("/lanche")
    public ResponseEntity<Object> postLanche(@Valid @RequestBody LancheModel lanche){
    	return ResponseEntity.ok().body(service.comprarLanche(lanche));
    }
    
    @GetMapping("/lanches")
    public ResponseEntity<Object> getLanches(){
    	return ResponseEntity.ok().body(service.buscaListaCompraLanches());
    }
    
}
