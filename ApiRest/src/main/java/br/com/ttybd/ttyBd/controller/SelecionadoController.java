package br.com.ttybd.ttyBd.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ttybd.ttyBd.controller.dto.DetalhesDoSelecionadoDto;
import br.com.ttybd.ttyBd.controller.dto.SelecionadoDto;
import br.com.ttybd.ttyBd.controller.form.AtualizarSelecionadoForm;
import br.com.ttybd.ttyBd.controller.form.SelecionadoForm;
import br.com.ttybd.ttyBd.modelo.Selecionado;
import br.com.ttybd.ttyBd.repository.ClienteRepository;
import br.com.ttybd.ttyBd.repository.SelecionadoRepository;
@RestController
@RequestMapping("/selecionados")
public class SelecionadoController {
	@Autowired
	private SelecionadoRepository selecionadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<SelecionadoDto> lista(Integer id){
		if(id ==null) {
			List<Selecionado> selecionados=selecionadoRepository.findAll();
			return SelecionadoDto.converter(selecionados);	
		}else {
			List<Selecionado> selecionados=selecionadoRepository.findByNome("Taty");
			return SelecionadoDto.converter(selecionados);
			
		}
		
		

		
	}
	@PostMapping
	@Transactional
	
	
	public   ResponseEntity<SelecionadoDto> cadastrar(@RequestBody  @Valid SelecionadoForm form, UriComponentsBuilder uriComponentsBuilder) {
		Selecionado selecionado=form.converter(clienteRepository);
		selecionadoRepository.save(selecionado);
		URI uri= uriComponentsBuilder.path("/selecionados/{id}").buildAndExpand(selecionado.getId()).toUri();
		return ResponseEntity.created(uri).body(new SelecionadoDto(selecionado));
		
	}
	@GetMapping("/{id}")
	public DetalhesDoSelecionadoDto detalhar(@PathVariable Long id) {
	Selecionado selecionado=	selecionadoRepository.getById(id);
	return new DetalhesDoSelecionadoDto(selecionado);
		
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<SelecionadoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarSelecionadoForm form){
	Selecionado selecionado	=form.atualizacao(id,selecionadoRepository);
	return ResponseEntity.ok (new SelecionadoDto(selecionado));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id){
		selecionadoRepository.deleteById(id);
		return ResponseEntity.ok().build();
		
	}

}
