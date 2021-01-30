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
@Entity // será mapeada no banco de dados
public class Cliente extends Usuario{

	@Column(length = 11,  nullable = false)
	@NotBlank(message = "O CPF não pode ser vazio")
	@Pattern(regexp = "[0-9]{11}", message = "O CPF possui formato inválido")
	private String cpf;
	
	@Column(length = 8,  nullable = false)
	@Pattern(regexp = "[0-9]{8}", message = "O CEP possui formato inválido")
	@NotBlank(message = "O CEP não pode ser vazio")
	private String cep;
	
}
