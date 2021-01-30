package br.com.softblue.bluefood.domain.usuario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.softblue.bluefood.util.StringUtils;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // apenas nos atributos que eu definir
@MappedSuperclass // dizer para JPA que apesar dessa classe não ser uma entidade, ela faz parte de uma outra entidade criada
public class Usuario implements Serializable{

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //automaticamente gera um ID de um em um
	private Integer id;
	
	@Column(nullable = false)
	@NotBlank(message = "O NOME não pode ser vazio")
	@Size(max = 80, message = "O nome é muito grande")
	private String nome;
	
	@Column(nullable = false)
	@NotBlank(message = "O Email não pode ser vazio")
	@Size(max = 60, message = "O email é muito grande")
	@Email(message = "O e-mail é inválido")
	private String email;
	
	@Column(nullable = false)
	@NotBlank(message = "A senha não pode ser vazio")
	@Size(max = 80, message = "A senha é muito grande")
	private String senha;
	
	@NotBlank(message = "A senha não pode ser vazio")
	@Pattern(regexp = "[0-9]{10,11}", message = "O Telefone possui formato inválido")
	@Column(length = 11, nullable = false)
	private String telefone;
	
	public void encryptPassword() {
		this.senha = StringUtils.encrypt(this.senha);
	}
	
	
	
}
