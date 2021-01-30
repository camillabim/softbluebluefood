package br.com.softblue.bluefood.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softblue.bluefood.domain.cliente.Cliente;
import br.com.softblue.bluefood.domain.cliente.ClienteRepository;
import br.com.softblue.bluefood.domain.restaurante.Restaurante;
import br.com.softblue.bluefood.domain.restaurante.RestauranteRepository;

//CLASSE DE SERVIÇO - AGRUPAR UM CONJUNTO DE INFORMAÇÕES QUE NAO FAZEM SENTIDO ESTAR DENTRO DE UMA CLASSE DE DOMINIO
@Service //para entender que é uma classe de serviço
public class RestauranteService {

	//NO SERVICE AS ENTIDADES JÁ SÃO GERENCIÁVEIS (MANAGED)
	
	@Autowired //PARA USAR A instancia de clienteRepository
	private RestauranteRepository restauranteRepository;
	
	public void saveRestaurante(Restaurante restaurante) throws ValidationException{
		if(!validateEmail(restaurante.getEmail(), restaurante.getId())) {
			throw new ValidationException("O email está duplicado");
		}
		
		restauranteRepository.save(restaurante);
	}
	
	private boolean validateEmail(String email, Integer id) {
		Restaurante restaurante = restauranteRepository.findByEmail(email);
		if(restaurante != null) {
			if(id == null) {
				return false;
			}
			if(!restaurante.getId().equals(id)) {
				return false;
			}
			
		}
		return true;
	}
	
}
