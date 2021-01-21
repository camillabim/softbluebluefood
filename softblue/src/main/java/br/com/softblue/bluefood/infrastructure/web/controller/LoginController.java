package br.com.softblue.bluefood.infrastructure.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //para dizer para o spring que trata de um controller
public class LoginController {

	//NO CONTROLLER AS ENTIDADES NÃO SÃO GERENCIÁVEIS (DETACHED)
	
	/** método para abrir a página de login
	 **/
	@GetMapping(path = { "/login", "/" 	})
	public String login() {
		return "login";
	}
	
}
