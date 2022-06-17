package br.com.ttybd.ttyBd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ttybd.ttyBd.modelo.Selecionado;

public interface SelecionadoRepository extends JpaRepository<Selecionado, Long> {

	 List<Selecionado> findByNome(String nome); 
	

	

	

}
