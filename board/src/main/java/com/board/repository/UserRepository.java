package com.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.board.model.User;

//DAO
// 자동으로 bean 등록
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	// JPA Naming 쿼리
	// SELECT * FROM user WHERE username = ? AND password =? 
//	User findByUsernameAndPassword(String username, String password);

//	@Query(value="SELECT * FROM user WHERE username = ?1 AND password = ?2", nativeQuery=true)
//	User login(String username, String password);
	
	
}
