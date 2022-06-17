package br.com.ttybd.ttyBd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ttybd.ttyBd.modelo.Cliente;
import br.com.ttybd.ttyBd.modelo.Selecionado;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	 Cliente findByNome(String nome);
	

		
		
	

}
