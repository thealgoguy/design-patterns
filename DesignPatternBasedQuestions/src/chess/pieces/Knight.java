package chess.pieces;


public class Knight extends Piece{
	public Knight(int x, int y, PieceColour col) {
    	this.type = PieceType.KNIGHT;
    	this.xCoordinate = x;
    	this.yCoordinate = y;
    	this.colour = col;
    }

}
