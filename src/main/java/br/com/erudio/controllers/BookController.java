package br.com.erudio.controllers;

import java.util.List;

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

import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.services.BookServices;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/book/v1")
public class BookController {

	@Autowired
	private BookServices bookService;
	
	@ApiOperation(value = "Find all books recorded")
	@GetMapping(produces = {"application/json","application/xml", "application/x-yaml"})
	public List<BookVO> findByAll() {
		
		return bookService.findAll();
		
	}

	@ApiOperation(value = "Find books by id")
	@GetMapping(value = "/{id}" , produces = {"application/json","application/xml", "application/x-yaml"})
	public BookVO findById(@PathVariable("id") Long id) {
		BookVO bookVO = bookService.findById(id);
//		bookVO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		return bookVO;
	}
	
	@ApiOperation(value = "Create a book record")
	@PostMapping(produces = {"application/json","application/xml", "application/x-yaml"},
			consumes = {"application/json", "application/xml", "application/x-yaml"})
	public BookVO create(@RequestBody BookVO BookVO) {
		
		return bookService.create(BookVO);
		
	}
	
	@ApiOperation(value = "Find all books recorded V2")
	@PostMapping(value = "v2", produces = {"application/json","application/xml", "application/x-yaml"},
			consumes = {"application/json", "application/xml", "application/x-yaml"})
	public BookVO createv2(@RequestBody BookVO BookVO) {
		
		return bookService.create(BookVO);
		
	}
	
	
	@PutMapping(produces = {"application/json","application/xml", "application/x-yaml"},
			consumes = {"application/json", "application/xml", "application/x-yaml"})
	public BookVO update(@RequestBody BookVO BookVO) {
		
		return bookService.update(BookVO);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		
		bookService.delete(id);
		return ResponseEntity.ok().build();
		
	}
}
