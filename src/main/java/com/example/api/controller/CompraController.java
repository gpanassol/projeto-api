package com.example.api.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @RequestMapping("/teste")
    @ResponseBody
    public Map<String, Object> calculetLunchs(){

    	Map<String, Object> response = new LinkedHashMap<>();
        response.put("success", true);
        response.put("messages", "");
        response.put("object", "");

        return response;
    }
	
}
