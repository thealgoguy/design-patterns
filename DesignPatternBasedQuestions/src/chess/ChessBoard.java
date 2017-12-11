package chess;

import java.util.List;
import chess.pieces.Piece;
import chess.player.Player;

public class ChessBoard {
	private SquareSpot spot [][];
	private List<Piece> deadPieces; 
	private boolean gameOver = false;


	public ChessBoard() {
		//create square spots
		this.spot = new SquareSpot[8][];
		for(int i=0; i<8; i++) {
			spot[i] = new SquareSpot[8];
			for(int j=0; j<8; j++) spot[i][j] = new SquareSpot(i, j);
		}
		//
	}



	public boolean executeMove(Player p) {
		//execute the move command for this player
	}



	public boolean isGameOver() {
		return gameOver;
	}



	public SquareSpot[][] getSpot() {
		return spot;
	}



	public void setSpot(SquareSpot[][] spot) {
		this.spot = spot;
	}



	public List<Piece> getDeadPieces() {
		return deadPieces;
	}



	public void setDeadPieces(List<Piece> deadPieces) {
		this.deadPieces = deadPieces;
	}



	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

}
