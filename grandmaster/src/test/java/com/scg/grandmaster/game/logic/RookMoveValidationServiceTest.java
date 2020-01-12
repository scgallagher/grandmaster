package com.scg.grandmaster.game.logic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.scg.grandmaster.exception.IllegalMoveException;
import com.scg.grandmaster.game.entity.Piece;

@RunWith(PowerMockRunner.class)
@PrepareForTest(CommonLogic.class)
public class RookMoveValidationServiceTest {

	@InjectMocks
	RookMoveValidationService rookMoveValidationService;
	
	@Mock
	Board board;
	
	RookMoveValidationService spiedRookMoveValidationService;
	
	@Before
	public void setup() {
		PowerMockito.mockStatic(CommonLogic.class);
		spiedRookMoveValidationService = PowerMockito.spy(rookMoveValidationService);
	}

	@Test
	public void isPathBlocked_DownVerticalPathIsBlockedReturnsTrue() {
		Integer destinationRow = 3;
		Integer destinationColumn = 0;
		Integer obstructionRow = 2;
		
		when(board.getPieceAt(obstructionRow, destinationColumn)).thenReturn(new Piece());
		
		PowerMockito.when(CommonLogic.isAlly(any(), any())).thenReturn(Boolean.TRUE);
		
		Boolean result = rookMoveValidationService.isPathBlocked(0, 0, destinationRow, destinationColumn);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlocked_UpwVerticalPathIsBlockedReturnsTrue() {
		Integer destinationRow = 0;
		Integer destinationColumn = 0;
		Integer obstructionRow = 2;
		
		when(board.getPieceAt(obstructionRow, destinationColumn)).thenReturn(new Piece());
		
		PowerMockito.when(CommonLogic.isAlly(any(), any())).thenReturn(Boolean.TRUE);
		
		Boolean result = rookMoveValidationService.isPathBlocked(3, 0, destinationRow, destinationColumn);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlocked_RightHorizontalPathIsBlockedReturnsTrue() {
		Integer destinationRow = 0;
		Integer destinationColumn = 3;
		Integer obstructionColumn = 2;
		
		when(board.getPieceAt(destinationRow, obstructionColumn)).thenReturn(new Piece());
		
		PowerMockito.when(CommonLogic.isAlly(any(), any())).thenReturn(Boolean.TRUE);
		
		Boolean result = rookMoveValidationService.isPathBlocked(0, 0, destinationRow, destinationColumn);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlocked_LeftHorizontalPathIsBlockedReturnsTrue() {
		Integer destinationRow = 0;
		Integer destinationColumn = 0;
		Integer obstructionColumn = 2;
		
		when(board.getPieceAt(destinationRow, obstructionColumn)).thenReturn(new Piece());
		
		PowerMockito.when(CommonLogic.isAlly(any(), any())).thenReturn(Boolean.TRUE);
		
		Boolean result = rookMoveValidationService.isPathBlocked(0, 3, destinationRow, destinationColumn);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlocked_PathIsNotBlockedHorizontallyReturnsTrue() {
		when(board.getPieceAt(any(), any())).thenReturn(null);
		
		Boolean result = rookMoveValidationService.isPathBlocked(0, 3, 0, 0);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isPathBlocked_DestinationIsOccupiedByAllyReturnsTrue() {
		Integer destinationRow = 0;
		Integer destinationColumn = 0;
		
		when(board.getPieceAt(destinationRow, destinationColumn)).thenReturn(new Piece());
		
		PowerMockito.when(CommonLogic.isAlly(any(), any())).thenReturn(Boolean.TRUE);
		
		Boolean result = rookMoveValidationService.isPathBlocked(0, 3, destinationRow, destinationColumn);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlocked_DestinationIsOccupiedByOpponentReturnsFalse() {
		Integer destinationRow = 0;
		Integer destinationColumn = 0;
		
		when(board.getPieceAt(destinationRow, destinationColumn)).thenReturn(new Piece());
		
		PowerMockito.when(CommonLogic.isAlly(any(), any())).thenReturn(Boolean.FALSE);
		
		Boolean result = rookMoveValidationService.isPathBlocked(0, 3, destinationRow, destinationColumn);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isPathBlocked_DestinationIsUnoccupiedReturnsFalse() {
		when(board.getPieceAt(any(), any())).thenReturn(null);
		
		PowerMockito.when(CommonLogic.isAlly(any(), any())).thenReturn(Boolean.FALSE);
		
		Boolean result = rookMoveValidationService.isPathBlocked(0, 3, 0, 0);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidMove_ValidVerticalMoveReturnsTrue() {
		Boolean result = rookMoveValidationService.isValidMove(0, 0, 3, 0);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMove_ValidHorizontalMoveReturnsTrue() {
		Boolean result = rookMoveValidationService.isValidMove(0, 0, 0, 3);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMove_NotValidVerticalOrHorizontalMoveReturnsFalse() {
		Boolean result = rookMoveValidationService.isValidMove(0, 0, 3, 3);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void validateMove_ValidVerticalOrHorizontalMoveSuccess() {
		doReturn(Boolean.TRUE).when(spiedRookMoveValidationService).isValidMove(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(spiedRookMoveValidationService).isPathBlocked(any(), any(), any(), any());
		
		spiedRookMoveValidationService.validateMove(null, null, null, null);
	}
	
	@Test
	public void validateMove_BlockedPathThrowsException() {
		doReturn(Boolean.TRUE).when(spiedRookMoveValidationService).isValidMove(any(), any(), any(), any());
		
		doReturn(Boolean.TRUE).when(spiedRookMoveValidationService).isPathBlocked(any(), any(), any(), any());
		
		assertThatThrownBy(() -> spiedRookMoveValidationService.validateMove(null, null, null, null)).isInstanceOf(IllegalMoveException.class);
	}
	
	@Test
	public void validateMove_DiagonalPathThrowsException() {
		doReturn(Boolean.FALSE).when(spiedRookMoveValidationService).isValidMove(any(), any(), any(), any());
		
		assertThatThrownBy(() -> spiedRookMoveValidationService.validateMove(null, null, null, null)).isInstanceOf(IllegalMoveException.class);
	}
	
}
