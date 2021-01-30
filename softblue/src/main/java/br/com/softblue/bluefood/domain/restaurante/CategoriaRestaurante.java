package br.com.softblue.bluefood.domain.restaurante;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/*relacionamento de muitos para muitos com restaurante*/

@SuppressWarnings("serial")
@Entity
@Table(name = "categoria_restaurante")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CategoriaRestaurante implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(max = 20)
	@NotNull
	private String nome;
	
	@NotNull
	@Size(max = 50)
	private String imagem;
	
	@ManyToMany(mappedBy = "categorias") //a configuração sempre faço no dono do relacionamento, neste caso, escolhemos que o dono seria o restaurante por ser uma entidade mais forte
	private Set<Restaurante> restaurantes;
}
