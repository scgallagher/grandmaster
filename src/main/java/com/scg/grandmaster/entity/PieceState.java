package com.scg.grandmaster.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PieceState")
@Table(name = "piece_state", schema = "grandmaster")
public class PieceState {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
//	@Column(name = "game_state_id")
//	private Integer gameStateId;

	@Column(name = "color", nullable = false)
	private String color;
	
	@Column(name = "piece_type", nullable = false)
	private String pieceType;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "short_name", nullable = false)
	private String shortName;
	
	@Column(name = "location_row", nullable = false)
	private Integer row;
	
	@Column(name = "location_column", nullable = false)
	private Integer column;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "game_state_id", nullable = false, insertable = true, updatable = true)
	private GameState gameState;
	
}
