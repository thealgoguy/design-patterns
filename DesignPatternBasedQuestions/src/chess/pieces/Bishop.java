package chess.pieces;


public class Bishop extends Piece{
	public Bishop(int x, int y, PieceColour col) {
    	this.type = PieceType.BISHOP;
    	this.xCoordinate = x;
    	this.yCoordinate = y;
    	this.colour = col;
    }

}
