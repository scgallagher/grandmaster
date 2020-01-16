package com.scg.grandmaster.game.logic;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class QueenMoveValidationServiceTest {

	@Spy
	@InjectMocks
	QueenMoveValidationService queenMoveValidationService;
	
	@Mock
	Board board;
	
}
