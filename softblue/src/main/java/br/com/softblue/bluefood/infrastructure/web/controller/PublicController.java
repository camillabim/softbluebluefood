package br.com.softblue.bluefood.infrastructure.web.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.softblue.bluefood.application.ClienteService;
import br.com.softblue.bluefood.application.ValidationException;
import br.com.softblue.bluefood.domain.cliente.Cliente;
import br.com.softblue.bluefood.domain.restaurante.CategoriaRestaurante;
import br.com.softblue.bluefood.domain.restaurante.CategoriaRestauranteRepository;
import br.com.softblue.bluefood.domain.restaurante.Restaurante;

@Controller // para falar que é um controller
@RequestMapping(path = "/public")//toda vez q eu acessar  /public  ele sabe que é um método daqui que tem que ser chamado
public class PublicController {

	@Autowired //PARA USAR A instancia de clienteRepository
	private ClienteService clienteService;
	
	@Autowired
	private CategoriaRestauranteRepository categoriaRestauranteRepository;
	
	@GetMapping("/cliente/new")
	public String newCliente(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente); //retornando para a view "cliente"
		ControllerHelper.setEditMode(model, false);
		return "cliente-cadastro";
	}
	
	@GetMapping("/restaurante/new")
	public String newRestaurante(Model model) {
		Restaurante restaurante = new Restaurante();
		model.addAttribute("restaurante", restaurante); //retornando para a view "cliente"
		ControllerHelper.setEditMode(model, false);
		//carregar categoria
		ControllerHelper.addCategoriasToRequest(categoriaRestauranteRepository, model);
		return "restaurante-cadastro";
	}
	
	@PostMapping(path = "/cliente/save")
	public String saveCliente(
			@ModelAttribute("cliente") 
			@Valid Cliente cliente,//valid faz a ligação entre spring mvc e a validation 
			Errors errors, //verificar se o cliente deu erro ou não
			Model model) {
		if(!errors.hasErrors()) { //se não deu erro
			try {
				clienteService.saveCliente(cliente);
				model.addAttribute("msg", "Cliente gravado com sucesso!");
			}catch(ValidationException e) {
				errors.rejectValue("email", null, e.getMessage());
			}
			
		}
		ControllerHelper.setEditMode(model, false);
		return "cliente-cadastro";
	}
	
}
