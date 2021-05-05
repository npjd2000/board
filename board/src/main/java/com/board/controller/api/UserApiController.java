package com.board.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.board.dto.ResponseDto;
import com.board.model.RoleType;
import com.board.model.User;
import com.board.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
//	@Autowired
//	private HttpSession session;

	@PostMapping("auth/joinProc")	
	public ResponseDto<Integer> save(@RequestBody User user) {
//		System.out.println("User Api 호출 : join");
		//실제로 db에 insert하고 아래에서 return됨
		user.setRole(RoleType.USER);
		userService.join(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	
//	@PostMapping("/api/user/join")	
//	public ResponseDto<Integer> save(@RequestBody User user) {
////		System.out.println("User Api 호출 : join");
//		//실제로 db에 insert하고 아래에서 return됨
//		user.setRole(RoleType.USER);
//		userService.join(user);
//		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
//	}
	
	
//	@PostMapping("/api/user/login")
//	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session){
//		System.out.println("User Api 호출 : login");
//		User principal = userService.login(user);  // principal = 접근주체 
//		
//		if (principal != null) {
//			session.setAttribute("principal", principal);
//		}
//		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
//	}
	

}
