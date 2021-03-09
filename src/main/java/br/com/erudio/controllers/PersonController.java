package br.com.erudio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.services.PersonServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Api(value = "person Endpoint", description = "Descricaod de pessoa", tags = "personendpoint ")
@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

	@Autowired
	private PersonServices personService;
	
	@CrossOrigin(origins="http://localhost:8080")
	@ApiOperation(value = "Find all pepoples recorded")
	@GetMapping(produces = {"application/json","application/xml", "application/x-yaml"})
	public List<PersonVO> findByAll() {
		
		return personService.findAll();
		
	}

	@ApiOperation(value = "Find people by id")
	@GetMapping(value = "/{id}" , produces = {"application/json","application/xml", "application/x-yaml"})
	public PersonVO findById(@PathVariable("id") Long id) {
		PersonVO personVO = personService.findById(id);
//		personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return personVO;
	}
	
	@ApiOperation(value = "Create a people")
	@PostMapping(produces = {"application/json","application/xml", "application/x-yaml"},
			consumes = {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO create(@RequestBody PersonVO PersonVO) {
		
		return personService.create(PersonVO);
		
	}
	
	@ApiOperation(value = "Create a people V2")
	@PostMapping(value = "v2", produces = {"application/json","application/xml", "application/x-yaml"},
			consumes = {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO createv2(@RequestBody PersonVO PersonVO) {
		
		return personService.create(PersonVO);
		
	}
	
	
	@PutMapping(produces = {"application/json","application/xml", "application/x-yaml"},
			consumes = {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO update(@RequestBody PersonVO PersonVO) {
		
		return personService.update(PersonVO);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		
		personService.delete(id);
		return ResponseEntity.ok().build();
		
	}
}
