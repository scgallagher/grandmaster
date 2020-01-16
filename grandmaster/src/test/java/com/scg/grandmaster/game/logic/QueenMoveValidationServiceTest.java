package com.scg.grandmaster.game.logic;

import static org.junit.Assert.*;

import org.junit.Test;
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
	
	@Test
	public void testName() {
		
	}
}
