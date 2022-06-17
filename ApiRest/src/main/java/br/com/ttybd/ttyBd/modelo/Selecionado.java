package br.com.ttybd.ttyBd.modelo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Selecionado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	

	private Long id;
	
	private String nome;
	@ManyToOne
	private Cliente cliente;
	@Override
	public int hashCode() {
		return Objects.hash(cliente, id, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Selecionado other = (Selecionado) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Selecionado() {
		
	}
	
	public Selecionado(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
		
	}
	
	
	
	

}
