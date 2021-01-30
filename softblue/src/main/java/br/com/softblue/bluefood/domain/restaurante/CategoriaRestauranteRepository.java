package br.com.softblue.bluefood.domain.restaurante;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.softblue.bluefood.domain.cliente.Cliente;

public interface CategoriaRestauranteRepository extends JpaRepository<CategoriaRestaurante, Integer>{

	
	
}
