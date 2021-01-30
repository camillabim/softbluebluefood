package br.com.softblue.bluefood.domain.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import br.com.softblue.bluefood.domain.usuario.Usuario;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity // ser� mapeada no banco de dados
public class Cliente extends Usuario{

	@Column(length = 11,  nullable = false)
	@NotBlank(message = "O CPF n�o pode ser vazio")
	@Pattern(regexp = "[0-9]{11}", message = "O CPF possui formato inv�lido")
	private String cpf;
	
	@Column(length = 8,  nullable = false)
	@Pattern(regexp = "[0-9]{8}", message = "O CEP possui formato inv�lido")
	@NotBlank(message = "O CEP n�o pode ser vazio")
	private String cep;
	
}
