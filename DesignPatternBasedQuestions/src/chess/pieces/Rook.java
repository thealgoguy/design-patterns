package chess.pieces;


public class Rook extends Piece{
	public Rook(int x, int y, PieceColour col) {
    	this.type = PieceType.ROOK;
    	this.xCoordinate = x;
    	this.yCoordinate = y;
    	this.colour = col;
    }

}
