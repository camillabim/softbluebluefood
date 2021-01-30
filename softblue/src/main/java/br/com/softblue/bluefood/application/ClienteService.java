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
	
	public void saveCliente(Cliente cliente) throws ValidationException{
		if(!validateEmail(cliente.getEmail(), cliente.getId())) {
			throw new ValidationException("O email est� duplicado");
		}
		if(cliente.getId() != null) { //estou editando o cliente
			Cliente clienteDB = clienteRepository.findById(cliente.getId()).orElseThrow();//pego no banco a versao atualizada
			cliente.setSenha(clienteDB.getSenha());
			
		}else {
			cliente.encryptPassword();
		}
		
		clienteRepository.save(cliente);
	}
	
	private boolean validateEmail(String email, Integer id) {
		Cliente cliente = clienteRepository.findByEmail(email);
		if(cliente != null) {
			if(id == null) {
				return false;
			}
			if(!cliente.getId().equals(id)) {
				return false;
			}
			
		}
		return true;
	}
	
}
