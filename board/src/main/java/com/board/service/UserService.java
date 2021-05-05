package com.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.board.model.User;
import com.board.repository.UserRepository;

//스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌, IOC해줌
@Service
public class UserService {

	@Autowired
	private UserRepository UserRepository;
	
//	@Transactional   // 하나의 트랙잭션으로 처리
//	public int join(User user) {
//		try {
//			UserRepository.save(user);
//			return 1;
//		} catch (Exception e) {
//           e.getStackTrace();
//           System.out.println("회원가입 실패" + e.getMessage());
//		}
//		return -1;		
//	}
	
	@Transactional
	public void join(User user) {
		UserRepository.save(user);
	}
	
//	@Transactional(readOnly = true)  // Select 할때, 트랜잭션 시작, 서비스 종료시 트랜잭션 종료(정합성 유지)
//	public User login(User user) {
//		return UserRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//	}
 }
