package com.board.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // object에서 필드를 get 할수 있음
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//@DynamicInsert   // insert시에 null 필드를 제외시킴
public class User {

	@Id //pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // 시퀀스,auto increment
	
	@Column(nullable = false, length = 30, unique = true)
	private String username;
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
//	@ColumnDefault("'user'")
//	private String role;  //Enum 사용
	@Enumerated(EnumType.STRING)
	private RoleType role;
	
	@CreationTimestamp // 시간이 자동 입력
	private Timestamp createDate;

}
