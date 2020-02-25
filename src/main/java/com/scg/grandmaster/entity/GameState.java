package com.scg.grandmaster.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "GameState")
@Table(name = "game_state", schema = "grandmaster")
public class GameState {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "state", nullable = false)
	private String state;
	
	@Column(name = "created_at", nullable = false, columnDefinition = "timestamp default now()")
	private LocalDateTime createdAt;
	
}
