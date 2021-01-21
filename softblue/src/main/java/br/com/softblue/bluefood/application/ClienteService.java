package br.com.softblue.bluefood.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softblue.bluefood.domain.cliente.Cliente;
import br.com.softblue.bluefood.domain.cliente.ClienteRepository;

//CLASSE DE SERVIÇO - AGRUPAR UM CONJUNTO DE INFORMAÇÕES QUE NAO FAZEM SENTIDO ESTAR DENTRO DE UMA CLASSE DE DOMINIO
@Service //para entender que é uma classe de serviço
public class ClienteService {

	//NO SERVICE AS ENTIDADES JÁ SÃO GERENCIÁVEIS (MANAGED)
	
	@Autowired //PARA USAR A instancia de clienteRepository
	private ClienteRepository clienteRepository;
	
	public void saveCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
}
