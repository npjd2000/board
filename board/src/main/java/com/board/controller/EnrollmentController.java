package com.board.controller;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.board.model.RoleType;
import com.board.model.User;
import com.board.repository.UserRepository;



@RestController
public class EnrollmentController {

	@Autowired  //의존성 주입(DI)
	private UserRepository userRepository;
	
	// http://localhost:8080/board/search
	@GetMapping("/search/{id}")
	public User detail(@PathVariable int id) {
		System.out.println("id : " + id);
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			
			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("해당 사용자가 없습니다.");
			}
		});
		
		// 요청 : web browser
		// user 객체 : 자바 object 
		// 변환 : 웹 브라우져가 이해할 수 있는 데이터 -> json (Gson 라이브러리)
		// 스프링 부트 : MessageConverter 가 응답시에 자동으로 작동
		// 만약 자바 오브젝트를 리턴하게 되면 MessageConverter이 Jackson 라이브러리를 호출해서  
		// User object를 json 변환해서 브라우져에게 전달
		return user;
	}
	
	//http://localhost:8080/board/join1
//	@PostMapping("/join1")
//	private String join(String username, String password, String email) {		
//		System.out.println("username" + username);
//		System.out.println("password" + password);
//		System.out.println("email" + email);
//		return "회원 가입 완료1";		
//	}

	//http://localhost:8080/board/join2
	@PostMapping("/join2")
	private String join(User user) {	// key=value 규칙
	    
		System.out.println("id" + user.getId());
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPassword());
		System.out.println("email : " + user.getEmail());
		System.out.println("role : " + user.getRole());
		System.out.println("createDate : " + user.getCreateDate());
		
		// ENUM
		user.setRole(RoleType.USER); 
		userRepository.save(user);
		return "회원 가입 완료2";		

	}
	
	// http://localhost:8080/board/searchList
	@GetMapping("/searchList")
	public List<User> list(){
		return userRepository.findAll();
	}
	
	// 한 페이지에 2건의 데이터를 리턴
	// http://localhost:8080/board/pageList
	// http://localhost:8080/board/pageList?page=0 (1 page)
	// http://localhost:8080/board/pageList?page=1 (2 page)
	@GetMapping("/pageList")
	public Page<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){

		Page<User> users = userRepository.findAll(pageable);
		return users;
	}
	
	// Contents만 표시 
	// http://localhost:8080/board/pageList2
	@GetMapping("/pageList2")
	public List<User> pageList2(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
		
		Page<User> pagingUser = userRepository.findAll(pageable);
		List<User> users = pagingUser.getContent();
		return users;
	}

	// password, email 업데이트
	// postman : body > raw > JSON 선택하고 json 형식(key : value)으로 전송
	// http://localhost:8080/board/userUpdate
	@PutMapping("/userUpdate/{id}")
	public User userUpdate(@PathVariable int id, @RequestBody User userRequest) {
		System.out.println("id : " + id);
		System.out.println("password : " + userRequest.getPassword());
		System.out.println("email : " + userRequest.getEmail());
		
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정에 실패했습니다.");
		});
		
		user.setPassword(userRequest.getPassword());
		user.setEmail(userRequest.getEmail());
		
		// save 함수
		// id를 전달하면 해당 id가 있으면 update
		// id를 전달하면 해당 id가 없으면 insert
		// id를 전달하지 않으면 insert 해줌
		userRepository.save(user);  // 더디 체킹 
		return null;
	}
}
