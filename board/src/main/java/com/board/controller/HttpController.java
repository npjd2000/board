package com.board.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HttpController {
    
	//인터넷 브라우져 요청은 get 요청만 가능
	//http://localhost:8080/http/get
	@GetMapping("/http/get")
	public String getTest(@RequestParam String id) {
		return "get 요청(조회)"+id;		
	}

	// post, put, delete는 postman에서 확인 가능 
	//http://localhost:8080/http/post
	// postman > body > x-www-form-uriencoded에 key/value 입력후 test
//	@PostMapping("/http/post")
//	public String postTest(Member m) {
//		return "post 요청(입력)" +m.getId()+"/"+m.getUsername()+"/"+m.getPassword()+"/"+m.getEmail();		
//	}

//	// postman > body > raw에 key/value 입력후 test (text/plain)
//	@PostMapping("/http/post")
//	public String postTest(@RequestBody String text) {
//		return "post 요청(입력)"+text;		
//	}
	
	// postman > body > json에 key/value 입력후 test (application/json)
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) {
		return "post 요청(입력)" + ":" + m.getId()+"/"+m.getUsername()+"/"+m.getPassword()+"/"+m.getEmail();		
	}
	
	//http://localhost:8080/http/put
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청(수정)"+ ":" + m.getId()+"/"+m.getUsername()+"/"+m.getPassword()+"/"+m.getEmail();		
	}
	
	//http://localhost:8080/http/delete
	@DeleteMapping("/http/delete")
	public String deleteTest(@RequestBody Member m) {
		return "delete 요청(삭제)" + ":" + m.getId()+"/"+m.getUsername()+"/"+m.getPassword()+"/"+m.getEmail();
	}
}
