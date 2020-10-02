package com.pelada.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JogadorControllersEscalacaoAno {

	
	@GetMapping("/janeiro")
    public String metodo_janeiro() {
        return "escalacoes_ano/janeiro";
    }
	
	@GetMapping("/fervereiro")
    public String metodo_fervereiro() {
        return "escalacoes_ano/fervereiro";
    }
	
	@GetMapping("/marco")
    public String metodo_marco() {
        return "escalacoes_ano/marco";
    }
	
	@GetMapping("/abril")
    public String metodo_abril() {
        return "escalacoes_ano/abril";
    }
	
	@GetMapping("/maio")
    public String metodo_maio() {
        return "escalacoes_ano/maio";
    }
	
	@GetMapping("/junho")
    public String metodo_junho() {
        return "escalacoes_ano/junho";
    }
	
	@GetMapping("/julho")
    public String metodo_julho() {
        return "escalacoes_ano/julho";
    }
	
	@GetMapping("/agosto")
    public String metodo_agosto() {
        return "escalacoes_ano/agosto";
    }
	
	@GetMapping("/setembro")
    public String metodo_setembro() {
        return "escalacoes_ano/setembro";
    }
	
	@GetMapping("/outubro")
    public String metodo_outubro() {
        return "escalacoes_ano/outubro";
    }
	
	@GetMapping("/novembro")
    public String metodo_novembro() {
        return "escalacoes_ano/novembro";
    }
	
	@GetMapping("/dezembro")
    public String metodo_dezembro() {
        return "escalacoes_ano/dezembro";
    }
	
}
