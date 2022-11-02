package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.bean.book;
import com.masai.dao.BooksDao;



@RestController
@RequestMapping("/bookservice")
public class mycontroller {

	@Autowired
	private BooksDao bk;
	
	@GetMapping("/books")
	public List<book> getallbooks(){
		
		return bk.findAll();
		
	}
	@PostMapping("/books")
	public book savebook(@RequestBody book b) {
		
		book bg= bk.save(b);
		return bg;
		
	}
	
	@GetMapping("/books/{id}")
	public book getbookbyid(@PathVariable int id) {
		return bk.findById(id).get();
	}
	
	@DeleteMapping("/books/{id}")
	public book deletebookbyid(@PathVariable int id) {
		book b=bk.findById(id).get();
		
		bk.deleteById(id);
		return b;
	
	}
	
	@PutMapping("books")
public book updatebook(@RequestBody book b) {
		
		return bk.save(b);
		
	}
}
