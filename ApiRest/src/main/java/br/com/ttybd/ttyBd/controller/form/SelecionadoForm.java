package br.com.ttybd.ttyBd.controller.form;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.ttybd.ttyBd.modelo.Cliente;
import br.com.ttybd.ttyBd.modelo.Selecionado;
import br.com.ttybd.ttyBd.repository.ClienteRepository;


public class SelecionadoForm {
	@NotNull
	private Long id;
	@NotNull
	@Length(min = 3)
	private String nome;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
public	Selecionado converter(ClienteRepository clienteRepository) {
	Cliente cliente= clienteRepository.findByNome(nome);
		return new Selecionado(id, nome);
		
	}
	
	
}
