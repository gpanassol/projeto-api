package br.com.dextra.api.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @RequestMapping("/teste")
    @ResponseBody
    public Map<String, Object> getDevices(){
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("success", true);
        response.put("messages", "");
        response.put("object", "[TESTE]");

        return response;
    }
}
