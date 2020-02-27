package com.scg.grandmaster.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(name = "created_at", columnDefinition = "timestamp default now()")
	private LocalDateTime createdAt;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "gameState", fetch = FetchType.EAGER)
	private List<PieceState> pieceStateList;
	
}
