package br.com.alura.forum.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.entity.ParceiroEntity;
import br.com.alura.forum.repository.ParceiroRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Parceiro")
@RestController
@RequestMapping("/api")
public class ParceiroService {

	@Autowired
	private ParceiroRepository repository;
	
	@ApiOperation(value = "Listar todos os parceiros")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ParceiroEntity> listaParceiros() {
		return (List<ParceiroEntity>) repository.findAll();
	}
	
	@ApiOperation(value = "Criar um novo parceiro")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ParceiroEntity> salvaParceiro(@RequestBody ParceiroEntity parceiro){
		return ResponseEntity.ok(repository.save(parceiro));
	}
}
