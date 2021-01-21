package br.com.softblue.bluefood.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softblue.bluefood.domain.cliente.Cliente;
import br.com.softblue.bluefood.domain.cliente.ClienteRepository;

//CLASSE DE SERVI�O - AGRUPAR UM CONJUNTO DE INFORMA��ES QUE NAO FAZEM SENTIDO ESTAR DENTRO DE UMA CLASSE DE DOMINIO
@Service //para entender que � uma classe de servi�o
public class ClienteService {

	//NO SERVICE AS ENTIDADES J� S�O GERENCI�VEIS (MANAGED)
	
	@Autowired //PARA USAR A instancia de clienteRepository
	private ClienteRepository clienteRepository;
	
	public void saveCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
}
