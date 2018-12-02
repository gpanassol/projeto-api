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
import com.example.api.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {

	@Autowired
	CompraService service;
	
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
	
    @PostMapping("/lanches")
    public ResponseEntity<Object> getLanches(@Valid @RequestBody LanchesModel lanches){
    	return ResponseEntity.ok().body(service.comprarLanches(lanches));
    }
}
