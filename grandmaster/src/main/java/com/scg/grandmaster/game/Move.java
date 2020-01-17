package com.scg.grandmaster.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Move {
	private Integer sourceRow;
	private Integer sourceColumn;
	private Integer destinationRow;
	private Integer destinationColumn;
}
