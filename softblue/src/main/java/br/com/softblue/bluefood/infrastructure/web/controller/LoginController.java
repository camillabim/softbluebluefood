package br.com.softblue.bluefood.infrastructure.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //para dizer para o spring que trata de um controller
public class LoginController {

	//NO CONTROLLER AS ENTIDADES N�O S�O GERENCI�VEIS (DETACHED)
	
	/** m�todo para abrir a p�gina de login
	 **/
	@GetMapping(path = { "/login", "/" 	})
	public String login() {
		return "login";
	}
	
}
