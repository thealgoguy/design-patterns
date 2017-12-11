package chess;

import chess.pieces.Piece;

//should provide APIs to occupy it and release it by a Piece
public class SquareSpot {
    private Piece piece;
    private int xCoordinate, yCoordinate;
    private boolean occupied;
    
    public SquareSpot(int x, int y) {
    	this.xCoordinate = x;
    	this.yCoordinate = y;
    	this.occupied = false;
    }

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
    
}
