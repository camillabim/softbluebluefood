package br.com.softblue.bluefood.domain.restaurante;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.softblue.bluefood.domain.usuario.Usuario;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Table(name = "restaurante")
public class Restaurante extends Usuario{

	
	@NotBlank(message = "O CNPJ n�o pode ser vazio")
	@Pattern(regexp = "[0-9]{14}", message = "O CNPJ possui formato inv�lido")
	@Column(length = 14, nullable = false)
	private String cnpj;
	
	@Size(max = 80)
	private String logotipo;
	
	@NotBlank(message = "A taxa de entrega n�o pode ser vazia") // not null � para outros valores sem ser string
	@Min(0)// usa sempre para intervalos num�ricos
	@Max(99)// usa sempre para intervalos num�ricos
	private BigDecimal taxaEntrega;
	
	@NotBlank(message = "O tmepo de entrega n�o pode ser vazio") // not null � para outros valores sem ser string
	@Min(0)// usa sempre para intervalos num�ricos
	@Max(120) // usa sempre para intervalos num�ricos
	private Integer tempoEntregaBase;
	
	
	@ManyToMany
	@JoinTable(name = "restaurante_has_categoria",
		       joinColumns = @JoinColumn(name = "restaurante_id"),
			   inverseJoinColumns = @JoinColumn(name = "caregoria_restaurante_id"))
	private Set<CategoriaRestaurante> categorias = new HashSet<>(0);
	
	
}
