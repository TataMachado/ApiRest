package br.com.ttybd.ttyBd.controller.dto;

import br.com.ttybd.ttyBd.modelo.Selecionado;

public class DetalhesDoSelecionadoDto {
	private Long id;
	private String nome;
	
	
	public DetalhesDoSelecionadoDto(Selecionado selecionado) {
		this.id=selecionado.getId();
		this.nome=selecionado.getNome();
		
	}


	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}
	


}
