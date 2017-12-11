package chess.pieces;


public class King extends Piece{
	public King(int x, int y, PieceColour col) {
    	this.type = PieceType.KING;
    	this.xCoordinate = x;
    	this.yCoordinate = y;
    	this.colour = col;
    }

}
