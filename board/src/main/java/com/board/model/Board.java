package com.board.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // auto_increment
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob //대용량 데이터
	private String content;
	
	@ColumnDefault("0")
	private int count;  //조회수

//	@ManyToOne // Many = Board, One = User
	@ManyToOne(fetch = FetchType.EAGER) // Many = Board, One = User
	@JoinColumn(name = "userId")
	private User user;  // DB는 오브젝트 저장 불가하나 FK, 자바는 오브젝트 저장 가능
	

	@OneToMany(mappedBy = "board", fetch = FetchType.LAZY)  //mappedBy는 연관관계의 주인이 아니다.
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate;
	
	
}
