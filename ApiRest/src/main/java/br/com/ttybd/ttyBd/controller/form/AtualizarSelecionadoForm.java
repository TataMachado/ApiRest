package br.com.ttybd.ttyBd.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.ttybd.ttyBd.modelo.Selecionado;
import br.com.ttybd.ttyBd.repository.SelecionadoRepository;

public class AtualizarSelecionadoForm {

	@NotNull
	@Length(min = 3)
	@NotEmpty
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public Selecionado atualizacao(Long id, SelecionadoRepository selecionadoRepository) {
		Selecionado selecionado= selecionadoRepository.getById(id);
		selecionado.setNome(this.nome);
		
		
		return selecionado;
	}
	
	
	
}
