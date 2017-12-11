package chess.pieces;


public class Queen extends Piece{
	public Queen(int x, int y, PieceColour col) {
    	this.type = PieceType.QUEEN;
    	this.xCoordinate = x;
    	this.yCoordinate = y;
    	this.colour = col;
    }

}
