package com.board.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpController {
    
	//인터넷 브라우져 요청은 get 요청만 가능
	//http://localhost:8080/http/get
	@GetMapping("/http/get")
	public String getTest() {
		return "get 요청(조회)";		
	}

	// post, put, delete는 postman에서 확인 가능 
	//http://localhost:8080/http/post
	@PostMapping("/http/post")
	public String postTest() {
		return "post 요청(입력)";		
	}

	//http://localhost:8080/http/put
	@PutMapping("/http/put")
	public String putTest() {
		return "put 요청(수정)";		
	}
	
	//http://localhost:8080/http/delete
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청(삭제)";		
	}
}
