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
public class BishopMoveValidationServiceTest {

	@InjectMocks
	BishopMoveValidationService bishopMoveValidationService;
	
	@Mock
	Board board;
	
	BishopMoveValidationService spiedBishopMoveValidationService;
	
	@Before
	public void setup() {
		PowerMockito.mockStatic(CommonLogic.class);
		spiedBishopMoveValidationService = PowerMockito.spy(bishopMoveValidationService);
	}
	
	@Test
	public void isPathBlocked_DownRightPathIsBlockedByAllyReturnsTrue() {
		Integer occupiedRow = 5;
		Integer occupiedColumn = 5;
		
		when(board.getPieceAt(occupiedRow, occupiedColumn)).thenReturn(new Piece());
		
		Boolean result = bishopMoveValidationService.isPathBlocked(4, 4, 6, 6);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlocked_DownRightPathIsNotBlockedReturnsFalse() {
		when(board.getPieceAt(any(), any())).thenReturn(null);
		
		Boolean result = bishopMoveValidationService.isPathBlocked(4, 4, 6, 6);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isPathBlocked_DownLeftPathIsBlockedByAllyReturnsTrue() {
		Integer occupiedRow = 5;
		Integer occupiedColumn = 3;
		
		when(board.getPieceAt(occupiedRow, occupiedColumn)).thenReturn(new Piece());
		
		Boolean result = bishopMoveValidationService.isPathBlocked(4, 4, 6, 2);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlocked_DownLeftPathIsNotBlockedReturnsFalse() {
		when(board.getPieceAt(any(), any())).thenReturn(null);
		
		Boolean result = bishopMoveValidationService.isPathBlocked(4, 4, 6, 2);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isPathBlocked_UpLeftPathIsBlockedByAllyReturnsTrue() {
		Integer occupiedRow = 3;
		Integer occupiedColumn = 3;
		
		when(board.getPieceAt(occupiedRow, occupiedColumn)).thenReturn(new Piece());
		
		Boolean result = bishopMoveValidationService.isPathBlocked(4, 4, 2, 2);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlocked_UpLeftPathIsNotBlockedReturnsFalse() {
		when(board.getPieceAt(any(), any())).thenReturn(null);
		
		Boolean result = bishopMoveValidationService.isPathBlocked(4, 4, 2, 2);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isPathBlocked_UpRightPathIsBlockedByAllyReturnsTrue() {
		Integer occupiedRow = 3;
		Integer occupiedColumn = 5;
		
		when(board.getPieceAt(occupiedRow, occupiedColumn)).thenReturn(new Piece());
		
		Boolean result = bishopMoveValidationService.isPathBlocked(4, 4, 2, 6);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlocked_UpRightPathIsNotBlockedReturnsFalse() {
		when(board.getPieceAt(any(), any())).thenReturn(null);
		
		Boolean result = bishopMoveValidationService.isPathBlocked(4, 4, 2, 6);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isPathBlocked_DestinationIsOccupiedByAllyReturnsTrue() {
		Integer occupiedRow = 6;
		Integer occupiedColumn = 6;
		
		when(board.getPieceAt(occupiedRow, occupiedColumn)).thenReturn(new Piece());
		PowerMockito.when(CommonLogic.isAlly(any(), any())).thenReturn(Boolean.TRUE);
		
		Boolean result = bishopMoveValidationService.isPathBlocked(4, 4, 6, 6);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlocked_DestinationIsOccupiedByOpponentReturnsFalse() {
		Integer occupiedRow = 6;
		Integer occupiedColumn = 6;
		
		when(board.getPieceAt(occupiedRow, occupiedColumn)).thenReturn(new Piece());
		PowerMockito.when(CommonLogic.isAlly(any(), any())).thenReturn(Boolean.FALSE);
		
		Boolean result = bishopMoveValidationService.isPathBlocked(4, 4, 6, 6);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidMove_DownRightDiagonalReturnsTrue() {
		Boolean result = bishopMoveValidationService.isValidMove(4, 4, 6, 6);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMove_DownLeftDiagonalReturnsTrue() {
		Boolean result = bishopMoveValidationService.isValidMove(4, 4, 6, 2);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMove_UpLeftDiagonalReturnsTrue() {
		Boolean result = bishopMoveValidationService.isValidMove(4, 4, 2, 2);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMove_UpRightDiagonalReturnsTrue() {
		Boolean result = bishopMoveValidationService.isValidMove(4, 4, 2, 6);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMove_UpStraightReturnsFalse() {
		Boolean result = bishopMoveValidationService.isValidMove(4, 4, 2, 4);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void validateMove_ValidVerticalOrHorizontalMoveSuccess() {
		doReturn(Boolean.TRUE).when(spiedBishopMoveValidationService).isValidMove(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(spiedBishopMoveValidationService).isPathBlocked(any(), any(), any(), any());
		
		spiedBishopMoveValidationService.validateMove(null, null, null, null);
	}
	
	@Test
	public void validateMove_BlockedPathThrowsException() {
		doReturn(Boolean.TRUE).when(spiedBishopMoveValidationService).isValidMove(any(), any(), any(), any());
		
		doReturn(Boolean.TRUE).when(spiedBishopMoveValidationService).isPathBlocked(any(), any(), any(), any());
		
		assertThatThrownBy(() -> spiedBishopMoveValidationService.validateMove(null, null, null, null)).isInstanceOf(IllegalMoveException.class);
	}
	
	@Test
	public void validateMove_DiagonalPathThrowsException() {
		doReturn(Boolean.FALSE).when(spiedBishopMoveValidationService).isValidMove(any(), any(), any(), any());
		
		assertThatThrownBy(() -> spiedBishopMoveValidationService.validateMove(null, null, null, null)).isInstanceOf(IllegalMoveException.class);
	}
}
