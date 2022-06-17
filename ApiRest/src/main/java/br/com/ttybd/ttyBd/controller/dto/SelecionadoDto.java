package br.com.ttybd.ttyBd.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.ttybd.ttyBd.modelo.Selecionado;

public class SelecionadoDto {

	@NotNull
	
	private Long id;
	
	@NotEmpty
	@NotNull
	@Length(max = 3)
	private String nome;
	
	public SelecionadoDto(Selecionado selecionado) {
		this.id=selecionado.getId();
		this.nome=selecionado.getNome();
		
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public static List<SelecionadoDto> converter(List<Selecionado> selecionados) {
		
		return selecionados.stream().map(SelecionadoDto:: new).collect(Collectors.toList());
	}
	
	

}
