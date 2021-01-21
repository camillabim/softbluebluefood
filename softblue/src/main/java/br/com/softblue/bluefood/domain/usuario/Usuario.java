package br.com.softblue.bluefood.domain.usuario;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

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
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	
	
	
	
	
}
