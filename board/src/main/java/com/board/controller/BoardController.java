package com.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController{
	
	@GetMapping({"","/"})  //슬래시 넣거나 안넣거나 둘다 허용
	public String index() {
		//WEB-INF/views/index.jsp
		//src/main/resources/templates/index.html
		return "index";
	}
}
