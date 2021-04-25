package com.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.board.model.User;

// 자동으로 bean 등록
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
