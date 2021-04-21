package com.board.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class User {

	@Id //pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // 시퀀스,auto increment
	
	@Column(nullable = false, length = 30)
	private String username;
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
//	@ColumnDefault("user")
	@ColumnDefault("'user'")
	private String role;  //Enum 사용
	
	@CreationTimestamp // 시간이 자동 입력
	private Timestamp createDate;
	
	
}
