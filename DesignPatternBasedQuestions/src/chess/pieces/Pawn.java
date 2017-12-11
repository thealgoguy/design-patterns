package chess.pieces;


public class Pawn extends Piece{
    public Pawn(int x, int y, PieceColour col) {
    	this.type = PieceType.PAWN;
    	this.xCoordinate = x;
    	this.yCoordinate = y;
    	this.colour = col;
    }


}
