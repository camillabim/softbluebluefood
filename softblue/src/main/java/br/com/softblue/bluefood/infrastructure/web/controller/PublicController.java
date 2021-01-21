package br.com.softblue.bluefood.infrastructure.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.softblue.bluefood.application.ClienteService;
import br.com.softblue.bluefood.domain.cliente.Cliente;


@Controller // para falar que é um controller
@RequestMapping(path = "/public")//toda vez q eu acessar  /public  ele sabe que é um método daqui que tem que ser chamado
public class PublicController {

	@Autowired //PARA USAR A instancia de clienteRepository
	private ClienteService clienteService;
	
	@GetMapping("/cliente/new")
	public String newCliente(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente); //retornando para a view "cliente"
		//ControllerHelper.setEditMode(model, false);
		return "cliente-cadastro";
	}
	
	@PostMapping("/cliente/save")
	public String saveCliente(@ModelAttribute("cliente") Cliente cliente) {
		clienteService.saveCliente(cliente);
		return "cliente-cadastro";
	}
	
	
}
