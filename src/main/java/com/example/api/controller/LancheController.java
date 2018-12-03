package com.example.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.service.LancheService;

@RestController
@RequestMapping("/cardapio")
public class LancheController {

	@Autowired
	LancheService service;
	
    @GetMapping("/xbacon")
    @ResponseBody
    public ResponseEntity<Object> getXBacon(){
        return ResponseEntity.ok().body(service.getXBacon());
    }

    @GetMapping("/xburguer")
    @ResponseBody
    public ResponseEntity<Object> getXBuguer(){
        return ResponseEntity.ok().body(service.getxBuguer());
    }
    
    @GetMapping("/xegg")
    @ResponseBody
    public ResponseEntity<Object> getXEgg(){
        return ResponseEntity.ok().body(service.getxEgg());
    }
    
    @GetMapping("/xeggbacon")
    @ResponseBody
    public ResponseEntity<Object> getXEggBacon(){
        return ResponseEntity.ok().body(service.getxEggBacon());
    }
    
    @GetMapping("/todos")
    @ResponseBody
    public ResponseEntity<Object> getTodosLanches(){
        return ResponseEntity.ok().body(service.getTodosLanches());
    }
}
